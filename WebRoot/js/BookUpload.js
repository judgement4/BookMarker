/**本脚本用于上传资源，调用百度 PCS API中的“上传单个文件”
 * 
 */
var UpUrl = "https://pcs.baidu.com/rest/2.0/pcs/file?method=upload&path=/apps/wp2pcs/1.JPG&access_token="+BaiduToken;
var BaiduToken = "23.602b4347dd6c5e1433702e668c14ffca.2592000.1441441319.891701231-1641135";
var UpReq;
var textXml;

function Upload(){
	UpReq = new XMLHttpRequest();
	UpReq.overrideMimeType("text/xml");
	UpReq.open("POST", UpUrl, true);
	UpReq.onreadystatechange = UploadResp;
	UpReq.send(null);
}

function UploadResp(){
	var info;
	textXml = UpReq.responseXML;
	info = document.getElementById("info");
	info.innerHTML = "<p>"+textXml.getElementsByTagName("path")[0].childNodes[0].nodeValue+"</p>";
	
}