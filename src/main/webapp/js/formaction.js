function setaction(formid, servlet) {
    const pathname = window.document.location.pathname;
    const pa = pathname.substring(0, pathname.substr(1).indexOf('/') + 1);
    document.getElementById(formid).setAttribute("action", pa + "/"+servlet);
}