// Quasar.lang.set(Quasar.lang.zhHans)
// var appVM = new Vue({
//     el : '#q-app',
//     data : function() {
//         return {
//             type : '',
//             typeDictItems : [],
//             title : '',
//             tableDataLoading : false,
//             tablePagination : {
//                 page : 1,
//                 rowsPerPage : 10,
//                 rowsNumber : 10
//             },
//             tableColumns : [ {
//                 align : 'left',
//                 name : 'id',
//                 label : 'id'
//             },
//                 {
//                     align : 'left',
//                     name : 'img',
//                     field : 'img',
//                     label : '图片'
//                 },
//                 {
//                 align : 'left',
//                 name : 'createTime',
//                 field : 'createTime',
//                 label : '创建时间'
//             },  {
//                 align : 'left',
//                 name : 'action',
//                 label : '操作'
//             } ],
//             tableData : [],
//             showAddOrUpdateDialogFlag : false,
//             addOrUpdateAction : '',
//             selectedNotice : '',
//             showViewNoticeFlag : false
//         }
//     },
//     mounted : function() {
//         var that = this;
//         that.findTypeItem();
//         that.loadTableData({
//             pagination : this.tablePagination
//         });
//     },
//     methods : {
//
//         findTypeItem : function() {
//             var that = this;
//             that.$http.get('/dictconfig/findDictItemInCache', {
//                 params : {
//                     dictTypeCode : 'noticeType'
//                 }
//             }).then(function(res) {
//                 this.typeDictItems = res.body.data;
//             });
//         },
//
//         viewNotice : function(notice) {
//             this.selectedNotice = notice;
//             this.showViewNoticeFlag = true;
//         },
//
//         delNotice : function(id) {
//             var that = this;
//             that.$q.dialog({
//                 title : '提示',
//                 message : '确定要删除吗?',
//                 cancel : true,
//                 persistent : true
//             }).onOk(function() {
//                 that.$http.get('/notice/delById', {
//                     params : {
//                         id : id
//                     }
//                 }).then(function(res) {
//                     that.$q.notify({
//                         progress : true,
//                         timeout : 1000,
//                         type : 'positive',
//                         message : '操作成功',
//                     });
//                     that.refreshTable();
//                 });
//             });
//         },
//
//         showAddDialog : function() {
//             this.showAddOrUpdateDialogFlag = true;
//             this.addOrUpdateAction = 'add';
//             this.selectedNotice = {
//                 title : '',
//                 content : '',
//                 type : '',
//                 publishTime : dayjs().format('YYYY-MM-DD HH:mm')
//             };
//         },
//
//         refreshTable : function() {
//             this.loadTableData({
//                 pagination : {
//                     page : 1,
//                     rowsPerPage : this.tablePagination.rowsPerPage,
//                     rowsNumber : 10
//                 }
//             });
//         },
//
//         loadTableData : function(param) {
//         }
//
//     },
// });