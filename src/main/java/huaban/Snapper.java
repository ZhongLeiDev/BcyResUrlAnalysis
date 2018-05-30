package huaban;

import java.util.List;

import huaban.beans.HuabanPicture;

public class Snapper {

  private String boardUrl;
  private static Snapper snapper;

  public static Snapper getInstance( )
  {
    if (snapper == null) {
      snapper = new Snapper();
    }
    return snapper;
  }

  public Snapper setBoardUrl(String boardUrl) {
    this.boardUrl = boardUrl;
    return snapper;
  }

  public List<HuabanPicture> getAllPictures() {

    PinCollector pc = new PinCollector(this.boardUrl);
    pc.collect();
    return pc.getAllPins();

  }

}
