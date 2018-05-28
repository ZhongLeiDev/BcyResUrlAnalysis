package bcy.beans;

/**
 * 相册封面和链接集合类
 * @author ZhongLei
 *
 */
public class AlbumCoverAndUrl {

	/**
	 * 相册封面
	 */
	private String albumCover;

	/**
	 * 相册链接
	 */
	private String albumUrl;

	public AlbumCoverAndUrl(String albumCover, String albumUrl) {
		this.albumCover = albumCover;
		this.albumUrl = albumUrl;
	}

	public String getAlbumCover() {
		return albumCover;
	}

	public void setAlbumCover(String albumCover) {
		this.albumCover = albumCover;
	}

	public String getAlbumUrl() {
		return albumUrl;
	}

	public void setAlbumUrl(String albumUrl) {
		this.albumUrl = albumUrl;
	}

	@Override
	public String toString() {
		return "AlbumCoverAndUrl [albumCover=" + albumCover + ", albumUrl=" + albumUrl + "]";
	}

}
