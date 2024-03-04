function setaction(formid, servlet) {
    const pathname = window.document.location.pathname;
    const pa = pathname.substring(0, pathname.substr(1).indexOf('/') + 1);
    document.getElementById(formid).setAttribute("action", pa + "/"+servlet);
}



function getPath() {
    const pathname = window.document.location.pathname;
    const pa = pathname.substring(0, pathname.substr(1).indexOf('/') + 1);
    return pa+""
}

function GetUrlParam(paraName) {
    let url = document.location.toString();
    let arrObj = url.split("?");
    if (arrObj.length > 1) {
        let arrPara = arrObj[1].split("&");
        let arr;
        for (let i = 0; i < arrPara.length; i++) {
            arr = arrPara[i].split("=");
            if (arr != null && arr[0] === paraName) {
                return arr[1];
            }
        }
        return "";
    }
    else {
        return "";
    }
}