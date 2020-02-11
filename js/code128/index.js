// Try edit message
function generateCode128B(numberToEncode, idCanvas) 
{
  const canvas = document.getElementById(idCanvas);
  canvas.setAttribute("shape-rendering", "crispEdges");
  const codePage128 = "6cc,66c,666,498,48c,44c,4c8,4c4,464,648,644,624,59c,4dc,4ce,5cc,4ec,4e6,672,65c,64e,6e4,674,76e,74c,72c,726,764,734,732,6d8,6c6,636,518,458,446,588,468,462,688,628,622,5b8,58e,46e,5d8,5c6,476,776,68e,62e,6e8,6e2,6ee,758,746,716,768,762,71a,77a,642,78a,530,50c,4b0,486,42c,426,590,584,4d0,4c2,434,432,612,650,7ba,614,47a,53c,4bc,49e,5e4,4f4,4f2,7a4,794,792,6de,6f6,7b6,578,51e,45e,5e8,5e2,7a8,7a2,5de,5ee,75e,7ae,684,690,69c,63a,6b8,18eb"
    .split(",").map(hex => ''+parseInt(hex, 16).toString(2));
  
  const moda = "0.025";
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
    createBlock('108', number.length+2);//end
  };
  const checkSumCalc = (startValue, encodedDigits) => {
    const checkSum = encodedDigits.reduce( (acc, value, index) => acc + (value * (index+1) ), startValue) % 103;
    return checkSum;
  }
 createBarcode(numberToEncode)
}
generateCode128B('1234567890123456','svgId');