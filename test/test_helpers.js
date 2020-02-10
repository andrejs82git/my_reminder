//Help hightlight the clickable areas
{
[...document.querySelectorAll("*")].filter(el=> getComputedStyle(el).cursor === "pointer").forEach(el=>el.style.outline = "solid pink");
}