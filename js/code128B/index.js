
{
  const idCanvas = 'svgId';
  const canvas = document.getElementById(idCanvas);
  const codePage128ValueString = '11011001100,11001101100,11001100110,10010011000,10010001100,10001001100,10011001000,10011000100,10001100100,11001001000,11001000100,11000100100,10110011100,10011011100,10011001110,10111001100,10011101100,10011100110,11001110010,11001011100,11001001110,11011100100,11001110100,11101101110,11101001100,11100101100,11100100110,11101100100,11100110100,11100110010,11011011000,11011000110,11000110110,10100011000,10001011000,10001000110,10110001000,10001101000,10001100010,11010001000,11000101000,11000100010,10110111000,10110001110,10001101110,10111011000,10111000110,10001110110,11101110110,11010001110,11000101110,11011101000,11011100010,11011101110,11101011000,11101000110,11100010110,11101101000,11101100010,11100011010,11101111010,11001000010,11110001010,10100110000,10100001100,10010110000,10010000110,10000101100,10000100110,10110010000,10110000100,10011010000,10011000010,10000110100,10000110010,11000010010,11001010000,11110111010,11000010100,10001111010,10100111100,10010111100,10010011110,10111100100,10011110100,10011110010,11110100100,11110010100,11110010010,11011011110,11011110110,11110110110,10101111000,10100011110,10001011110,10111101000,10111100010,11110101000,11110100010,10111011110,10111101110,11101011110,11110101110,11010000100,11010010000,11010011100,11000111010,11010111000,1100011101011';
  const codePage128 = codePage128ValueString.split(",");
  
  const moda = "0.06";
  const modeUnit = "cm";

  const createRect = (isBlack, xpos=0) => {
    const rect = document.createElementNS("http://www.w3.org/2000/svg", 'rect'); 
    rect.setAttribute("width",moda+modeUnit);
    rect.setAttribute("height","100%");
    rect.setAttribute("fill", (+isBlack) ? 'black': 'white');
    rect.setAttribute("x",(moda*xpos)+modeUnit);
    rect.setAttribute("y","0");
    return rect;
  };
  const createBlock = (symbolCodeNumber,  modaPos) => {
    const startPos = modaPos*11;
    const symbolEncodeBinary = codePage128[symbolCodeNumber];
    [...symbolEncodeBinary].forEach( (lineColor, index)=> {
      canvas.appendChild(createRect(lineColor, startPos + index));
    });
  };
  createBarcode = (number) => {
    createBlock(104, 0);//start
    const encodedValue= [...number]
      .map(numS=>parseInt(numS))
      .map(num=>num+16);
    encodedValue.forEach((encodedNum, index) => createBlock(encodedNum, index+1));
    createBlock(checkSumCalc(104, encodedValue), number.length+1)
    createBlock('106', number.length+2);//end
  };
  const checkSumCalc = (startValue, encodedDigits) => {
    const checkSum = encodedDigits.reduce( (acc, value, index) => acc + (value * (index+1) ), startValue) % 103;
    return checkSum;
  }
 createBarcode("99887766554433221100")
}