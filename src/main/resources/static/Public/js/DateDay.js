//返回两个日期相差的月数
function MonthsBetw(date1, date2) {
    var m1 = parseInt(date1.split("-")[1].replace(/^0+/, "")) + parseInt(date1.split("-")[0]) * 12;
    var m2 = parseInt(date2.split("-")[1].replace(/^0+/, "")) + parseInt(date2.split("-")[0]) * 12;
    
    return  m2-m1;
}