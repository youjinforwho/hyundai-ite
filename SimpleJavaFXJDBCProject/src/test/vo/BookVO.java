package test.vo;

//이놈은 VO로 사용할거에요 -> 이 안에 비즈니스 로직 사용 불가
//데이터에 대한 유효성 검사는 가능하지만 
//학점 계산 등의 로직은 다른 곳에서 처리하는 것이 원칙
public class BookVO {
	//필드 명은 컬럼명과 일치시켜주는 것이 좋음 => 처리가 편하기 때문에
	//전체 컬럼 중 필요한 컬럼만 필드에 정의해 줌
	//타입도 sql에 맞춰서 정의
	private String bisbn;
	private String btitle;
	private int bprice;
	private String bauthor;
	
	public BookVO() {
		
	}
	//편의상 만들어주는 것이 좋음
	public BookVO(String bisbn, String btitle, int bprice, String bauthor) {
		super();
		this.bisbn = bisbn;
		this.btitle = btitle;
		this.bprice = bprice;
		this.bauthor = bauthor;
	}
	public String getBisbn() {
		return bisbn;
	}
	public void setBisbn(String bisbn) {
		this.bisbn = bisbn;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public int getBprice() {
		return bprice;
	}
	public void setBprice(int bprice) {
		this.bprice = bprice;
	}
	public String getBauthor() {
		return bauthor;
	}
	public void setBauthor(String bauthor) {
		this.bauthor = bauthor;
	}
	@Override
	public String toString() {
		return bisbn + ":" + btitle + ":" + bprice +":"+ bauthor;
	}
	
}
