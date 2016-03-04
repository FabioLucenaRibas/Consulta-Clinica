/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classebasica;

import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author MegaKingBR
 */
public final class LetrasPermitidas extends PlainDocument{
    @Override
    public void insertString(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException {
        super.insertString(offset, str.replaceAll("[^a-z|^A-Z|^ |^á-ú|^Á-Ú|^à-ù|^À-Ù]",""),attr);
    }
    
    public void replace(int offset, String str, javax.swing.text.AttributeSet attr) throws BadLocationException {
        super.insertString(offset, str.replaceAll("[^a-z|^A-Z|^ |^á-ú|^Á-Ú|^à-ù|^À-Ù]",""),attr);
    }
   
}
