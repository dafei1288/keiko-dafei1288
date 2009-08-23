package basic.knowledge.algorithm.baidu.ant;

public class Ant {
	
	public static int  FACE_RIGHT = 1;
	public static int  FACE_LEFT = -1;
	
	
	private int position;
	private int face;
	private int setp = 0;
	
	private String name; 
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Ant(int position, int face) {
		super();
		this.position = position;
		this.face = face;
		this.name = "[position:"+position+" , face:"+face+" , setp"+setp+"]";
	}
	
	
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getFace() {
		return face;
	}
	public void setFace(int face) {
		this.face = face;
	}
	public int getSetp() {
		return setp;
	}
	public void setSetp(int setp) {
		this.setp = setp;
	}
	
	public void go(){
		this.setp++;
		this.position += this.face;
	}
	
	public void turn(){
		if(this.face == FACE_RIGHT){
			this.face = FACE_LEFT;
		}
		if(this.face == FACE_LEFT){
			this.face = FACE_RIGHT;
		}
	}
	@Override
	public String toString() {
		return "[position:"+position+" , face:"+face+" , setp:"+setp+"]";
	}
}
