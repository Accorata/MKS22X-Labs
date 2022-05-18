public class Kernel {
  float[][]kernel;

  public Kernel(float[][]init) {
    kernel = init;
  }

  /**If part of the kernel is off of the image, return black, Otherwise
   *Calculate the convolution of r/g/b separately, and return that color\
   *if the calculation for any of the r,g,b values is outside the range
   *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
   */
  color calcNewColor(PImage img, int x, int y) {
    return color(0,0,0);
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
  }

  /**You must write this method that applies the kernel to the source,
   *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
    for (int x = 0; x<width; x++) {
      for (int y = 0; y<height; y++) {
        color set = calcNewColor(source, x, y);
        destination.set(x,y,set);
      }
    }
  }
}
