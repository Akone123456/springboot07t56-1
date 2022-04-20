<template>
  <div>
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      label-width="80px"
	  style="background: transparent;"
    >
     <el-row>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yonghu'"  label="账号" prop="zhanghao">
          <el-input v-model="ruleForm.zhanghao" readonly              placeholder="账号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yonghu'"  label="姓名" prop="xingming">
          <el-input v-model="ruleForm.xingming"               placeholder="姓名" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item v-if="flag=='yonghu'"  label="性别" prop="xingbie">
          <el-select v-model="ruleForm.xingbie"  placeholder="请选择性别">
            <el-option
                v-for="(item,index) in yonghuxingbieOptions"
                v-bind:key="index"
                :label="item"
                :value="item">
            </el-option>
          </el-select>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yonghu'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji"               placeholder="手机" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yonghu'"  label="身份证" prop="shenfenzheng">
          <el-input v-model="ruleForm.shenfenzheng"               placeholder="身份证" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="24">
        <el-form-item v-if="flag=='yonghu'" label="头像" prop="touxiang">
          <file-upload
          tip="点击上传头像"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
          @change="yonghutouxiangUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yunshugongsi'"  label="公司编号" prop="gongsibianhao">
          <el-input v-model="ruleForm.gongsibianhao" readonly              placeholder="公司编号" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yunshugongsi'"  label="公司名称" prop="gongsimingcheng">
          <el-input v-model="ruleForm.gongsimingcheng"               placeholder="公司名称" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yunshugongsi'"  label="公司地址" prop="gongsidizhi">
          <el-input v-model="ruleForm.gongsidizhi"               placeholder="公司地址" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yunshugongsi'"  label="负责人" prop="fuzeren">
          <el-input v-model="ruleForm.fuzeren"               placeholder="负责人" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="12">
        <el-form-item   v-if="flag=='yunshugongsi'"  label="联系电话" prop="lianxidianhua">
          <el-input v-model="ruleForm.lianxidianhua"               placeholder="联系电话" clearable></el-input>
        </el-form-item>
      </el-col>
      <el-col :span="24">
        <el-form-item v-if="flag=='yunshugongsi'" label="营业执照" prop="yingyezhizhao">
          <file-upload
          tip="点击上传营业执照"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.yingyezhizhao?ruleForm.yingyezhizhao:''"
          @change="yunshugongsiyingyezhizhaoUploadChange"
          ></file-upload>
        </el-form-item>
      </el-col>
      <el-form-item v-if="flag=='users'" label="用户名" prop="username">
        <el-input v-model="ruleForm.username"
        placeholder="用户名"></el-input>
      </el-form-item>
      <el-col :span="24">
      <el-form-item>
        <el-button type="primary" @click="onUpdateHandler">修 改</el-button>
      </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="dialogForm.dialogFormVisible = true;">采集人脸信息</el-button>
        </el-form-item>
      </el-col>
      </el-row>
    </el-form>
    <el-dialog title="人脸识别" :visible.sync="dialogForm.dialogFormVisible" width="30%"
               style="text-align: center">
      <div class="container" style="text-align: center;">
        <video id="video" width="320" height="250">  </video>
        <p id="video_tip" >脸部识别中，请正脸看向摄像头</p>
        <canvas id="canvas" width="480" height="320" style="display: none;"></canvas>
        <p id="result"></p>
      </div>

      <div slot="footer" class="dialog-footer" style="text-align: center">
        <el-button type="primary" @click="saveFaceData()">确认采集</el-button>
      </div>
    </el-dialog>
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isMobile,isPhone,isURL,checkIdCard } from "@/utils/validate";

export default {
  data() {
    return {
      video: null,
      canvas : null,
      context : null,
      dialogForm:{
        dialogFormVisible:false
      },
      faceData:{
        img:''
      },
      ruleForm: {},
      flag: '',
      usersFlag: false,
      yonghuxingbieOptions: [],
    };
  },
  mounted() {
    var table = this.$storage.get("sessionTable");
    this.flag = table;
    this.$http({
      url: `${this.$storage.get("sessionTable")}/session`,
      method: "get"
    }).then(({ data }) => {
      if (data && data.code === 0) {
        this.ruleForm = data.data;
      } else {
        this.$message.error(data.msg);
      }
    });
    this.yonghuxingbieOptions = "男,女".split(',')
  },
  methods: {
    init(){
      const that = this
      this.$nextTick(() => {
        that.canvas = document.getElementById('canvas');
        that.context = this.canvas.getContext('2d')
        console.log(that.context)
        that.video = document.getElementById('video');
        // 旧版本浏览器可能根本不支持mediaDevices，我们首先设置一个空对象
        if (navigator.mediaDevices === undefined) {
          navigator.mediaDevices = {}
        }
        // 一些浏览器实现了部分mediaDevices，我们不能只分配一个对象
        // 使用getUserMedia，因为它会覆盖现有的属性。
        // 这里，如果缺少getUserMedia属性，就添加它。
        if (navigator.mediaDevices.getUserMedia === undefined) {
          navigator.mediaDevices.getUserMedia = function (constraints) {
            // 首先获取现存的getUserMedia(如果存在)
            var getUserMedia = navigator.webkitGetUserMedia || navigator.mozGetUserMedia || navigator.getUserMedia
            // 有些浏览器不支持，会返回错误信息
            // 保持接口一致
            if (!getUserMedia) {
              return Promise.reject(new Error('getUserMedia is not implemented in this browser'))
            }
            // 否则，使用Promise将调用包装到旧的navigator.getUserMedia
            return new Promise(function (resolve, reject) {
              getUserMedia.call(navigator, constraints, resolve, reject)
            })
          }
        }
        var constraints = {
          audio: false,
          video: {width: this.videoWidth, height: this.videoHeight, transform: 'scaleX(-1)'}
        }
        navigator.mediaDevices.getUserMedia(constraints).then(function (stream) {
          // 旧的浏览器可能没有srcObject
          if ('srcObject' in that.video) {
            that.video.srcObject = stream
          } else {
            // 避免在新的浏览器中使用它，因为它正在被弃用。
            that.video.src = window.URL.createObjectURL(stream)
          }
          that.video.onloadedmetadata = function () {
            that.video.play()
          }
        }).catch(err => {
          console.log(err)
        })
      })
    },
    getFace() {
      this.init()
      this.context.drawImage(this.video, 0, 0, 150, 150);
      var imgSrc = this.canvas.toDataURL('image/jpg')
      //获取完整的base64编码
      imgSrc = imgSrc.split(',')[1];
      return imgSrc;
    },
    saveFaceData() {
      this.faceData.img = this.getFace()
      console.log(this.faceData.img)
      let data = {
        ...ruleForm,
        img: this.faceData.img
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/yonghu/addFaceData`,
        method: "post",
        data: data
      }).then(({data}) => {
        if (data.code === 1) {
          this.$message({
            message: data.msg,
            type: "success",
            duration: 1500
          })
        }else {
          this.$message({
            message: data.msg,
            type: "error",
            duration: 1500
          })
        }
      })
    },
    yonghutouxiangUploadChange(fileUrls) {
        this.ruleForm.touxiang = fileUrls;
    },
    yunshugongsiyingyezhizhaoUploadChange(fileUrls) {
        this.ruleForm.yingyezhizhao = fileUrls;
    },
    onUpdateHandler() {
      if((!this.ruleForm.zhanghao)&& 'yonghu'==this.flag){
        this.$message.error('账号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'yonghu'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.xingming)&& 'yonghu'==this.flag){
        this.$message.error('姓名不能为空');
        return
      }
      if( 'yonghu' ==this.flag && this.ruleForm.shouji&&(!isMobile(this.ruleForm.shouji))){
        this.$message.error(`手机应输入手机格式`);
        return
      }
      if( 'yonghu' ==this.flag && this.ruleForm.shenfenzheng&&(!checkIdCard(this.ruleForm.shenfenzheng))){
        this.$message.error(`身份证应输入身份证格式`);
        return
      }
        if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
        }
      if((!this.ruleForm.gongsibianhao)&& 'yunshugongsi'==this.flag){
        this.$message.error('公司编号不能为空');
        return
      }
      if((!this.ruleForm.mima)&& 'yunshugongsi'==this.flag){
        this.$message.error('密码不能为空');
        return
      }
      if((!this.ruleForm.gongsimingcheng)&& 'yunshugongsi'==this.flag){
        this.$message.error('公司名称不能为空');
        return
      }
      if( 'yunshugongsi' ==this.flag && this.ruleForm.lianxidianhua&&(!isMobile(this.ruleForm.lianxidianhua))){
        this.$message.error(`联系电话应输入手机格式`);
        return
      }
        if(this.ruleForm.yingyezhizhao!=null) {
                this.ruleForm.yingyezhizhao = this.ruleForm.yingyezhizhao.replace(new RegExp(this.$base.url,"g"),"");
        }
      if('users'==this.flag && this.ruleForm.username.trim().length<1) {
	this.$message.error(`用户名不能为空`);
        return
      }
      this.$http({
        url: `${this.$storage.get("sessionTable")}/update`,
        method: "post",
        data: this.ruleForm
      }).then(({ data }) => {
        if (data && data.code === 0) {
          this.$message({
            message: "修改信息成功",
            type: "success",
            duration: 1500,
            onClose: () => {
            }
          });
        } else {
          this.$message.error(data.msg);
        }
      });
    }
  }
};
</script>
<style lang="scss" scoped>
</style>
