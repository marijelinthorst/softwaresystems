package ss.week2;

public class Rectangle {
    private int length;
    private int width;

    //@ invariant length()>=0;
    //@ invariant width()>=0;
    
    /**
     * Create a new Rectangle with the specified length and width.
     */
    //@ ensures length==length();
    //@ ensures width==width();
    public Rectangle(int length, int width) {
    	assert width>=0 && length>=0;
    	this.length=length;
    	this.width=width;
    }
    
    /**
     * The length of this Rectangle.
     */
    // @ ensures \return>=0;
    /*@ pure*/ public int length() {
    	assert length>=0;
    	return length;
    }

    /**
     * The width of this Rectangle. 
     */
    //@ ensures \result>=0;
    /*@ pure*/ public int width() {
    	assert width>=0;
    	return width;
    }

    /**
     * The area of this Rectangle.
     */
    //@ ensures \result==width()*length();
    /*@ pure*/ public int area() {
    	assert width>=0 && length>=0;
    	return width*length;
    }

    /**
     * The perimeter of this Rectangle.
     */
    //@ ensures \result==2*length()+2*width();
    /*@ pure*/ public int perimeter() {
    	assert width>=0 && length>=0;
    	return 2*length+2*width;
    }
}
