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
    if (x-1 < 0 || y-1 < 0 || x+1 >= img.width || y+1 >= img.height) {
      return color(0,0,0);
    }
    float r = 0, g = 0, b = 0;
    for (int i = -1; i<=1; i++){
      for (int j = -1; j<=1; j++){
        color current = img.get(x+i, y+j);
        r += red(current) * kernel[i+1][j+1];
        g += green(current) * kernel[i+1][j+1];
        b += blue(current) * kernel[i+1][j+1];
      }
    }
    return color(r,g,b);
  }

  /**You must write this method that applies the kernel to the source,
   *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
    for (int x = 0; x<source.width; x++) {
      for (int y = 0; y<source.height; y++) {
        color set = calcNewColor(source, x, y);
        destination.set(x,y,set);
      }
    }
  }
}
