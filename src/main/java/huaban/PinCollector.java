package huaban;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import huaban.beans.HuabanPicture;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PinCollector {
  private String boardUrl;
  private List<HuabanPicture> allPins;
  private int count;
  private WebClient webClient;

  public PinCollector(String boardUrl)
  {
    this.boardUrl = boardUrl;
    this.allPins = new ArrayList<HuabanPicture>();
    this.count = -1;

    this.webClient = new WebClient(BrowserVersion.FIREFOX_52);

    this.webClient.getOptions().setJavaScriptEnabled(false);
    this.webClient.getOptions().setCssEnabled(false);

    this.webClient.getOptions().setThrowExceptionOnScriptError(false);
    this.webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
  }

  public void collect() {
    getPinCount();
    if (this.count <= 0)
      return;

    System.out.println(this.count);
    System.out.println("开始分析所有图片的pin_id");
    int k = -1;
    while ((this.allPins.size() < this.count) && (k != 0))
    {
      List<HuabanPicture> pins;
      if (this.allPins.size() == 0)
        pins = getPins(null);
      else
        pins = getPins((HuabanPicture)this.allPins.get(this.allPins.size() - 1));

      k = 0;
      for (Iterator<HuabanPicture> localIterator = pins.iterator(); localIterator.hasNext(); ) {
        HuabanPicture pin = (HuabanPicture)localIterator.next();
        if (this.allPins.contains(pin)) break;
        this.allPins.add(pin);
        ++k;
      }

      System.out.println("@@@@@@@@@@@@@@@@@@@@@" + this.allPins.size());
      System.out.println("已分析" + this.allPins.size() + "/" + this.count);
    }
    System.out.println(this.allPins.toString());
    System.out.println("pin已分析完毕");
    this.webClient.close();
  }

  public List<HuabanPicture> getAllPins() {
    return this.allPins; }

  private void getPinCount() {
    HtmlPage rootPage;
    try { rootPage = (HtmlPage)this.webClient.getPage(this.boardUrl);
      System.out.println("为了获取js执行的数据 线程开始沉睡等待");
      Thread.sleep(5000L);
      this.count = parsePinCountFromXml(rootPage.asXml());
      System.out.println("该画板有" + this.count + "张图片");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private List<HuabanPicture> getPins(HuabanPicture img)
  {
    String url;
    List<HuabanPicture> pins = null;
    if (img == null)
      url = this.boardUrl;
    else {
      url = this.boardUrl + "?max=" + img.getPinId() + "&limit=20&wfl=1";
    }

    try
    {
      HtmlPage rootPage = (HtmlPage)this.webClient.getPage(url);
      System.out.println("为了获取js执行的数据 线程开始沉睡等待");
      Thread.sleep(5000L);
      pins = parsePinsFromXml(rootPage.asXml());
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return pins;
  }

  private int parsePinCountFromXml(String xmlStr) {
    String pattern = "\"pin_count\":(\\d+),";

    Pattern r = Pattern.compile(pattern);

    Matcher m = r.matcher(xmlStr);
    if (m.find())
      return Integer.parseInt(m.group(1));

    return -1;
  }

  private List<HuabanPicture> parsePinsFromXml(String xmlStr) {
    List<HuabanPicture> pins = new ArrayList<HuabanPicture>();
    String pattern = "\\{\"pin_id\":(\\d+),.+?\"key\":\"(.+?)\",.\"type\":\"image/(.+?)\",";

    Pattern r = Pattern.compile(pattern);

    Matcher m = r.matcher(xmlStr);
    while (m.find()) {
      HuabanPicture pin = new HuabanPicture();
      System.out.println(m.group());
      pin.setPinId(m.group(1));
      pin.setKey(m.group(2));
      pin.setType(m.group(3));
      pins.add(pin);
      System.out.println(pin.getPinId() + "," + pin.getKey() + "," + pin.getType());
    }
    return pins;
  }

}