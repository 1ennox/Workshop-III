package brewDay;

import java.util.Date;

public class Note {
	private String content;
	private Date createdDate;
	private int idOfNote;
	private Brew brew;
	
	public Note(String content, Date createdDate, int idOfNote, Brew brew) {
		this.content = content;
		this.createdDate = createdDate;
		this.idOfNote = idOfNote;
		this.brew = brew;
	}
	
	public boolean edit(String input) {
		if (input == null) {
			return false;
		}
		else {
			this.content = input;
			if(this.content.equals(input)) {
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean delete(int id) {
		if(this.idOfNote == id) {
			this.content = "";
			return true;
		}
		else {
			return false;
		}
	}
}
