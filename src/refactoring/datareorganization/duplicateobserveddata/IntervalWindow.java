package refactoring.datareorganization.duplicateobserveddata;

import java.util.Observable;
import java.util.Observer;

public class IntervalWindow extends java.awt.Frame implements Observer {
   java.awt.TextField _startField;
   java.awt.TextField _endField;
   java.awt.TextField _lengthField;

   class SymFocus extends java.awt.event.FocusAdapter {
      public void focusLost(java.awt.event.FocusEvent event) {
         Object object = event.getSource();
         if (object == _startField) {
            StartField_FocusLost(event);
         } else if (object == _endField) {
            EndField_FocusLost(event);
         } else if (object == _lengthField) {
            LengthField_FocusLost(event);
         }
      }

      void StartField_FocusLost(java.awt.event.FocusEvent event) {
         if (isNotInteger(_startField.getText())) {
            _startField.setText("0");
         }
         calculateLength();
      }
      void EndField_FocusLost(java.awt.event.FocusEvent event) {
         setEnd(_endField.getText());
         if (isNotInteger(getEnd())) {
             setEnd("0");
         }
         calculateLength();
      }
      void LengthField_FocusLost(java.awt.event.FocusEvent event) {
         if (isNotInteger(_lengthField.getText())) {
            _lengthField.setText("0");
         }
         calculateEnd();
      }

      boolean isNotInteger(String s) {
         return false;
      }

      void calculateLength() {
         try {
            int start = Integer.parseInt(_startField.getText());
            int end = Integer.parseInt(getEnd());
            int length = end - start;
            _lengthField.setText(String.valueOf(length));
         } catch (NumberFormatException e) {
            throw new RuntimeException("Un expected number format");
         }
      }

      void calculateEnd() {
         try {
            int start = Integer.parseInt(_startField.getText());
            int length = Integer.parseInt(_lengthField.getText());
            int end = start + length;
            setEnd(String.valueOf(end));
         } catch (NumberFormatException e) {
            throw new RuntimeException("Un expected number format");
         }
      }
   }

   public void update(Observable observed, Object arg) {
       _endField.setText(_subject.getEnd());
   }

   String getEnd() {
       return _subject.getEnd();
   }

   void setEnd(String arg) {
      _subject.setEnd(arg);
   }

   public IntervalWindow() {
      super();

      _subject = new Interval();
      _subject.addObserver(this);
      update(_subject, null);
   }

   private Interval _subject;
}
