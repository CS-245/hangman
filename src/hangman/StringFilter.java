/** *************************************************************
 * file: StringFilter.java
 * authors: Lenny Yang, Rachel Frodsham, Jenna Barrett
 * class: CS245 – Graphic User Interface (GUI)
 *
 * assignment: Point and Click Game – v.1.2
 * date last modified: 10/31/2017
 *
 * purpose: This code filters the String inputted for high scores name
 *
 *************************************************************** */
package hangman;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class StringFilter extends DocumentFilter{
    
    private int maxLength = 2;

    public void setMaxLength(int maxLength) {
        this.maxLength = maxLength;
    }

    public int getMaxLength() {
        return maxLength;
    }
    
    // method: replace
    // purpose:  method to replace the inputted string to formatted version    
    @Override
    public void replace(FilterBypass fb, int i, int i1, String string, AttributeSet as) throws BadLocationException {
        for (int n = string.length(); n > 0; n--) {
            char c = string.charAt(n - 1);
            if (Character.isAlphabetic(c)) {
                super.replace(fb, i, i1, (String.valueOf(c)).toUpperCase(), as);
            } 
            else {
            }
        }
    }

    // method: remove
    // purpose:  method to remove the incorrect input of String   
    @Override
    public void remove(FilterBypass fb, int i, int i1) throws BadLocationException {
        super.remove(fb, i, i1);
    }
    
    // method: insertString
    // purpose:  insert new String from remocin   
    @Override
    public void insertString(FilterBypass fb, int i, String string, AttributeSet as) throws BadLocationException {
        super.insertString(fb, i, string, as);

    }
}
