

/*
     * @description    根据某个字段实现对json数组的排序
     * @param   array  要排序的json数组对象
     * @param   field  排序字段（此参数必须为字符串）
     * @param   reverse 是否倒序（默认为false）
     * @return  array  返回排序后的json数组
    */
function jsonSort(array, field, reverse) {
    //数组长度小于2 或 没有指定排序字段 或 不是json格式数据
    if (array.length < 2 || !field || typeof array[0] !== "object") {
        return array;
    }
    //数字类型排序
    if (typeof array[0][field] === "number") {
        array.sort(function (x, y) {
            return x[field] - y[field]
        });
    }
    //字符串类型排序
    if (typeof array[0][field] === "string") {
        array.sort(function (x, y) {
            return x[field].localeCompare(y[field])
        });
    }
    //倒序
    if (reverse) {
        array.reverse();
    }
    return array;
}

/*
     * @description    根据某个数字类型字段实现对json数组的排序
     * @param   order  'desc'或'asc' 按正序或倒序排列
     * @param   sortBy  排序字段（此参数为数字类型）
     * @return  array  返回排序后的json数组
    */
//array.sort(getSortFun('desc','phone'));
function getSortFun(order, sortBy) {
    var ordAlpah = (order == 'asc') ? '>' : '<';
    var sortFun = new Function('a', 'b', 'return a.' + sortBy + ordAlpah + 'b.' + sortBy + '?1:-1');
    return sortFun;
}

//获取地址栏附带的信息
function getQueryVariable(variable)
{
    const query = window.location.search.substring(1);
    const vars = query.split("&");
    for (let i=0; i<vars.length; i++) {
        const pair = vars[i].split("=");
        if(pair[0] == variable){
            return decodeURI(pair[1]);
        }
    }
    return(false);
}

//让select框根据数据选中选项并刷新显示
function set_select_checked(selectId, checkValue){
    const select = document.getElementById(selectId);

    for (let i = 0; i < select.options.length; i++){
        if (select.options[i].value == checkValue){
            select.options[i].selected = true;
            break;
        }
    }
}
