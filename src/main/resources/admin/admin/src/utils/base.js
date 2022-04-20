const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot07t56/",
            name: "springboot07t56",
            // 退出到首页链接
            indexUrl: ''
        };
    },
    getProjectName(){
        return {
            projectName: "人脸识别物流运输管理系统"
        } 
    }
}
export default base
