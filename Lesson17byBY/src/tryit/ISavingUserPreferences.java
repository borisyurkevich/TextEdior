/**
 * TRY IT from LESSON 17
 * 
 * Special thanks to Yakov Fain and 
 * his wonderful book Java Programming 24-Hour Trainer
 * 
 * @author Yakov Fain
 * @author Boris Yurkevich
 */

package tryit;

import java.io.Serializable;

public class ISavingUserPreferences implements Serializable {
	
	public static final long serialVersionUID = 1;
	private String color = "Black";
	private String font = "Arial";
	private int fontSize = 14;

	public String getColor() {
		return color;
	}
	
	public String getFont() {
		return font;
	}
	
	public int getFontSize() {
		return fontSize;
	}
	
	public void setColor(String c) {
		color = c;
	}
	
	public void setFont(String f) {
		font = f;
	}
	
	public void setFontSize(int fs) {
		fontSize = fs;
	}

}