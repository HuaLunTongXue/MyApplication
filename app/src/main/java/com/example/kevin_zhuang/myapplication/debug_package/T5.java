package com.example.kevin_zhuang.myapplication.debug_package;

/**
 * <b>Project:</b> MyApplication<br>
 * <b>Create Date:</b> 2016/11/29<br>
 * <b>Author:</b> kevin_zhuang<br>
 * <b>Description:</b> <br>
 */
public class T5 {
        /*







ODOO API说明






























修订记录
版本
修订日期
修订内容
修订人
V1.0
2015/12/29
1增加登录接口
2增加获取产品列表接口
居福国

2015/12/29
1、	增加了修改密码接口
2、	用户注销接口
3、	购物车详情接口
刘成德

2016/1/4
1、	增加测试地址与测试账号
2、	修改初始化接口
3、	修改产品列表接口
居福国

2016/1/5
1、完善产品详情接口
居福国

2016/1/8
1、	增加用户联系地址查询接口
2、	增加用户地址添加和更新接口
3、	增加用户地址删除接口
居福国

2016/1/31
1、	更新产品列表接口，增加促销筛选项；增加建议销售价；增加利润率排序；增加按销量排序；返回数据中增加优惠政策信息（产品策划要求只返回product_template级别的促销信息且只有一个）
2、	增加购物车或订单价格计算接口，根据产品id和产品数量信息，结合相应的促销信息计算出最终的订单总价和相关优惠详情的接口
3、	修改获取地址列表，添加是否只返回默认地址选项；添加县或县级市字段；废掉删除地址接口，地址只支持修改或置为无效；其他修改见文档详细描述
居福国

2016/2/1
1、	修改地址列表接口只返回有效地址
产品列表接口添加政策icon、product_unit、修改图片链接等
居福国

2016/2/14
1、	购物车订单价格计算接口：添加discount_items字段（展示订单中折扣优惠详情），fullcut_total字段（表示满减优惠总金额），gift_tiems中添加policy_names字段（买赠优惠政策名称，如该赠品在多个政策中出现，政策名称为多个政策拼接而成）
2、	购物车订单价格计算接口添加参数校验
3、	产品列表中可以根据产品名称、产品分类等进行查询
居福国

2016/2/16
1、	地址列表中字段类型修改，city，country_id,state_id和county都为int
居福国

2016/2/17
1、	添加地址接口，增加email字段
2、	地址列表添加城市名称和区县名称字段
3、	产品列表，根据品牌id查询产品
居福国

2016/3/2
1、	产品列表和产品详情添加 sale_ok 字段
居福国

2016/3/3
1、增加更新地址json文件接口
居福国
测试地址与账号
	测试地址：http://10.128.231.240:8069
	DB：	odoo9_api
	User:	api
	Pwd:	123456

	公共用户：	public     用于未登录访问使用
	密码：		123456
1、用户相关接口
1.1 登录接口

请求URL
{base_url}/app_api/session/authenticate
api_authenticate
请求方式
POST

维护者
居福国

RequestJson
{
"jsonrpc":"2.0 可不填",
    "method":"call 可不填",
"params":{
    "app_version":"0.5.0",//app版本号
"method":"api_authenticate", //调用的函数
        "db":"数据库名称，必填",
        "login":"用户名，必填",
        "password":"密码，必填"
        "source":"boss" 该参数只提供给 Boss版本的登录用
    },
    "id":"01 字符串，可不填"
}

字段名

字段类型

中文含义

特殊说明


db

String

数据库名称

必填


login

String

用户名

必


assword

Strig

密码

必填




ResponseJson
成功：{
    "jsonrpc":"2.0",
    "id":01,
    "result":{
        "username":"13761381427",
        "user_context":{
            "lang":"zh_CN",
            "tz":"Asia\/Shanghai",
            "uid":6,
            "route_map_website_id":1,
            "route_start_partner_id":414,
            "map_website_id":1
        },
        "uid":6,
        "db":"jfg",
        "company_id":1,
        "role": null,
        Tags:[6],
      "session_id":"fce186e72bc8f351df4aaffbd8e583c5547acedd"
    }
}
失败：{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "error": "用户名或密码错误，请重新登录！",
    "title": "用户初始化"
  }
}
字段名

字段类型

中文含义

特殊说明


uid

int

用户id

成功后会返回该字段


session_id

String

session id

说明： session_id为后续请求需要字段
1、每个数据访问请求都会验证session_id的有效性和权限。
2、在app初始访问时，需要调用此接口，获取初始session_id，（未注册用户使用public，123456 ）
3、session_id需要app客户端缓存在本地。后续可使用缓存session_id直接访问数据接口。缓存有效时间服务器设定
4、需要访问高权限的接口前，先调用此接口进行登录操作，获得新的session_id, 客户端缓存的session_id需要同步更新，有效期同3.


role

String

角色

3种类型：
1、Terminal:用户
2、Dealer:业代
3、Admin：经销商

Null说明未分配角色




1.2 修改密码接口
请求URL
{base_url}/app_api/session/change_password
change_password
请求方式
POST

RequestJson
{
    "jsonrpc": "2.0",
"params": {
         "app_version":"0.5.0",//app版本号
"method":"change_password", //调用的函数
             "old_password":"111111", //原始密码
            "new_password":"123456"//新密码
           }

}

ResponseJson
成功：
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "msg": "密码更改成功",
    "title": "更改密码"
  }
}
{
  "jsonrpc": "2.0",
   "result": {
    "title": "更改密码",
    "error": "原密码错误更改失败."
  }
} {
说明：返回结果result中 有error的就是失败


1.3 用户登出接口
请求URL
{base_url}/app_api/session/destroy
destroy
请求方式
POST
说明：原始接口
RequestJson
{
    "jsonrpc": "2.0",
"params": {
"app_version":"0.5.0",//app版本号
"method":"destroy" //调用的函数

    }

}

ResponseJson
成功：
{
  "jsonrpc": "2.0",
  "result": {
    "msg": "注销成功 !",
    "title": "注销成功"
  }
}


1.4 用户地址接口
1.4.1 查询地址列表
请求URL
{base_url}/app_api/user/list_address
api_list_address
请求方式
POST

维护者
徐锐

RequestJson
{
  "jsonrpc": "2.0，可不填",
  "method": "call，可不填",
  "params": {
"app_version":"0.5.0",//app版本号
"method":"api_list_address", //调用的函数
    "is_default": true
  }
}
说明： is_default 参数为选填，存在且为true时，返回默认地址

ResponseJson
说明：终端客户访问这个接口时，只返回该客户所在公司自己创建的地址。
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "state_name": "上海市",
    "is_default": true,
    "street": "漕溪北路1号",
    "city_name": "上海市",
    "active": true,
    "id": 122,
    "city": 310001,
    "name": "杰威廉公司",
    "zip": "",
    "phone": "",
    "mobile": "15080783815",
    "country_id": 49,
    "county": 310104,
    "price_float": 10,
    "county_name": "徐汇区",
    "country_name": "中国",
    "state_id": 310000,
    "type": "cooperative",
"email": b2b@hollywant.com ,
"contact_name": "联系人隔壁老王"
    "records": [
      {
        "county": 110114,
        "name": "21111111",
        "zip": "2131",
        "city": 320100,
        "mobile": "242424",
        "county_name": "昌平区",
        "country_id": 49,
        "email": "1@1.com",
        "is_default": true,
        "phone": "423423",
        "street": "122",
        "city_name": "南京市",
        "country_name": "中国",
        "active": true,
        "state_id": 320000,
        "type": "delivery",
        "id": 43,
        "state_name": "江苏省"，
       "self_creation": True  //值为True时地址是客户自己创建，False时为业代创建
      }
    ]
  }
}
字段名

字段类型

中文含义

特殊说明


city

int

城市代码




name

String

姓名

收件或收货人


zip

String

邮编




mobile

String

手机号码




country_id

int

国家代码

中国默认是49


phone

String

电话




street

String

详细地址




country_name

String

国家名称




active

Boolean

有效性




state_id

int

省份代码




type

Strig

地址类

contact为发票地址，也可作为送货地址，不可删除；delivery为 送货地址可删除


is_default

Boolean

是否是默认地址




id

int

id




county

int

县市代码




city_name

String

城市名称




county_name

String

区县名称




state_name

String

省名称




display_name

String

地址名称，如家庭、公司








1.4.2 添加/修改地址信息
请求URL
{base_url}/app_api/user/update_address
api_update_address
请求方式
POST

维护者
徐锐

RequestJson
{
  "jsonrpc": "2.0",
"method":"call",
  "params": {
"app_version":"0.5.0",//app版本号
"method":"api_update_address", //调用的函数
    "args": [
      {
"id":9,//地址id，需要新增时传0，更新时传需要更新的地址id
        "name": "1111111",
        "street": "122",
        "city": 130100,
        "zip": "2131",
        "phone": "423423",
        "mobile": "242424",
        "email": "a@a.com",
        "type": "delivery",
        "country_id": 130100,
        "is_default": true,
        "active": true,
        "state_id": 130000,
"county": 130111
      }
    ]
  }
}
说明：需登录后进行操作
字段名

字段类型

中文含义

特殊说明


method

String

方法名

必填：add为添加地址，update为更新地址


id

int

地id

update时必填


name

String

姓名

收件或收货人


zip

String

邮编




mobile

String

手机号码

必填，前端控制


country_id

int

国家代码

必填，前端控制(中国默认为49)


phone

String

电话




email

String

邮箱




street

String

详细地址

必填，前端控制


country_name

String

国家名称




active

Boolean

有效性

必填，前端控制


state_id

int

省份代码

必填，前端控制


type

String

地址类型

可不用该字段


city

int

城市代码

必填，前端控制


county

int

县市代码

必填，前端控制




ResponseJson
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "msg": true
  }
}




1.4.3 删除地址信息（废除，地址不可删除，只可修改和置为无效）
请求URL
{base_url}/app_api/user/delete_address

请求方式
POST

维护者
居福国

RequestJson
{
  "jsonrpc": "2.0",
"method":"call",
  "params": {
    "id": 9
  }
}
说明：需登录后进行操作


ResponseJson
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "msg": true
  }
}




1.4.4 更新地址json文件接口
请求URL
{base_url}/app_api/user/get_address_version
api_address_json_version
请求方式
POST

维护者
居福国

RequestJson
{
    "jsonrpc":"2.0，可不填",
    "method":"call，可不填"
}


ResponseJson
{
"params": {
"app_version":"0.5.0",//app版本号
"method":"api_address_json_version" //调用的函数
}
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "url": "http://b2btest.hollywant.com:8070/web/content/1616?download=true",
    "version": "1.0"
  }
}



1.4.5 存储用户登陆地址接口
请求URL
{base_url}/app_api/ user/user_coordinate

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
        "latitude": 34.0,
        "longitude": 12.0
    },
    "method": "call",
    "id": 226937648
}

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 226937648,
    "result": {
        "msg": "存储用户登录定位信息成功",
        "data": {
            "coordinate_id": 2//用户经纬度地址id
        },
        "title": "存储用户登录定位信息成功"
    }
}
失败：odoo系统级异常

说明：


1.5 获取验证码接口
请求URL
{base_url}/app_api/session/verifycode

请求方式
POST

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
             "mobile":"18601611267", //手机号，
             }

}

ResponseJson
成功：
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {

                    "code":123456,

 }
}
失败：
{
                    "error": "请输入正确的手机号"
                    }
说明：返回结果result中 有error的就是失败



1.6 用户获取经销商信息接口
请求URL
{base_url}/app_api/user/supplier
get_supplier_info
请求方式
POST

维护者
孙洋

RequestJson
{
"params": {
"app_version":"0.5.0",//app版本号
"method":"get_supplier_info" //调用的函数
}
    "jsonrpc": "2.0",
    "method": "call",

    "id": 497381451
}说明：需登录后进行操作


ResponseJson
{
    "jsonrpc": "2.0",
    "id": 497381451,
    "result": {
        "city": "Scranton",  //城市
        "zip": "18540", //邮编
        "phone": "+1 555 123 8069",//电话
        "state": "Pennsylvania", //省
        "street": "1725 Slough Ave.", //街道地址
        "supplier_name": "YourCompany" //公司名称
       "logo": "http://localhost:8069/web/image/res.company/1/logo_web/300x300?unique=6ecf616"
    }
}





1.7 用户信息接口
1.7.1 用户信息获取
请求URL
{base_url}/app_api/user/user_info
get_user_info
请求方式
POST

维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
"params": {
"app_version":"0.5.0", //app版本号
"method":"get_user_info" //调用的函数
},
    "method": "call",
    "id": 462414149
}
说明：需登录后进行操作

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 462414149,
    "result": {
        "mobile_number": "15298362556", //联系方式
        "terminal_name": "北村超市", //昵称
        "iscarsales": false, //是否车销
        "isSaler": true, //是否业代
        "company": "上海如旺", //公司名称
"head_portrait":"http://localhost:8069/web/image?model=res.users;id=1;field=image;unique=20160204184543", //用户头像
    }
}
失败：
odoo系统错误




1.7.2 修改昵称
请求URL
{base_url}/app_api/user/edit_terminal_name
edit_terminal_name
请求方式
POST

维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
"params": {
    "app_version":"0.5.0",//app版本号
"method":"edit_terminal_name", //调用的函数
        "terminal_name": "旺旺食品厂"//商超名称
    },
    "method": "call",
    "id": 421974423
}
说明：需登录后进行操作

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 421974423,
    "result": {
        "msg": "修改昵称成功",
        "data": {},
        "title": "修改用户信息成功"
    }
}
失败：
{
    "title": "修改用户信息错误",
    "error": "修改昵称错误",
    "error_info": odoo系统错误
}




1.7.3 修改联系地址(已废弃，使用添加/修改地址信息接口)
请求URL
{base_url}/app_api/user/edit_terminal_addr

请求方式
POST

维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
        "terminal_address": "董村路112号"//联系地址
    },
    "method": "call",
    "id": 421974423
}
说明：需登录后进行操作

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 303848865,
    "result": {
        "msg": "修改店铺地址成功",
        "data": {},
        "title": "修改用户信息成功"
    }
}
失败：
{
    "title": "修改用户信息错误",
    "error": "修改联系地址错误",
    "error_info": odoo系统错误
}



1.7.4 修改头像
请求URL
{base_url}/app_api/user/edit_image
edit_image
请求方式
POST

维护者
张蔚文

RequestJson
{
    "jsonrpc": "2.0",
"params": {
"app_version":"0.5.0",//app版本号
"method":"edit_image", //调用的函数
        "image": "iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAIAAACQkWg2AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAeSURBVDhPY3gro0ISYiBJNVDxqAZiQmw0lAZHKAEAzxMtEF4sIn0AAAAASUVORK5CYII=" // 必须对二进制数据进行base64编码
    },
    "method": "call",
    "id": 421974423
}
说明：需登录后进行操作

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 26487066,
    "result": {
        "msg": "修改头像成功",
        "data": {},
        "title": "修改用户信息成功"
    }
}
失败：
{
    "title": "修改用户信息错误",
    "error": "修改头像错误",
    "error_info": odoo系统错误
}




1.7.5 修改联系方式
请求URL
{base_url}/app_api/user/edit_phone
edit_phone
请求方式
POST

维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
"params": {
    "app_version":"0.5.0",//app版本号
"method":"edit_phone", //调用的函数
        "mobile_number": "15298362669"，//联系方式,必须为加区号的固话或手机号码
        "verifycode": "123456"//验证码
    },
    "method": "call",
    "id": 421974423
}
说明：需登录后进行操作

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 26487066,
    "result": {
        "msg": "修改联系方式成功",
        "data": {},
        "title": "修改用户信息成功"
    }
}
失败：
{
    "title": "修改用户信息错误",
    "error": "修改联系地址错误",
    "error_info": odoo系统错误
}








1.7.6 用户创建反馈
请求URL
{base_url}/app_api/user/feedback
user_feedback_create
请求方式
POST

维护者
孙洋

RequestJson
{
    "jsonrpc": "2.0",
"params": {
"app_version":"0.5.0",//app版本号
"method":"user_feedback_create", //调用的函数
     "phone":"123456",
     "content":"this is a  feedback test",
        "image1": "iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAIAAACQkWg2AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAeSURBVDhPY3gro0ISYiBJNVDxqAZiQmw0lAZHKAEAzxMtEF4sIn0AAAAASUVORK5CYII="
}, // 必须对二进制数据进行base64编码
如果没有，请不要传递此参数
    "image2": "iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAIAAACQkWg2AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAeSURBVDhPY3gro0ISYiBJNVDxqAZiQmw0lAZHKAEAzxMtEF4sIn0AAAAASUVORK5CYII="
}, // 必须对二进制数据进行base64编码
如果没有，请不要传递此参数

    "image3": "iVBORw0KGgoAAAANSUhEUgAAABAAAAAQCAIAAACQkWg2AAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAAAeSURBVDhPY3gro0ISYiBJNVDxqAZiQmw0lAZHKAEAzxMtEF4sIn0AAAAASUVORK5CYII="
}, // 必须对二进制数据进行base64编码
如果没有，请不要传递此参数


    "method": "call",
    "id": 421974423
}
说明：需登录后进行操作

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 26487066,
    "result": {
        "msg": "修改联系方式成功",
        "data": {},
        "title": "修改用户信息成功"
    }
}
失败：
{
    "title": "修改用户信息错误",
    "error": "修改联系地址错误",
    "error_info": odoo系统错误
}








1.7.7 用户加入我们（OA用）
请求URL
{base_url}/hollywant/api_addus

请求方式
POST

维护者
毛涛

RequestJson
{
    "jsonrpc":"2.0",
    "method":"call",
    "params":{
        "name":"leon",
        "phone":"13112312312",
        "email":"123@qq.com",
        "option":"dealer",
        "write_date":"2016-07-21 00:00:00",  //当前时间
        "content":"How?"
    }
}
说明：无需登录
"option"选项取值
        'dealer', '我是经销商'
        'trader', '我是零售商'
        'brand', '我是品牌商'
        'isfree', '收费与否'
        'howtodo', '如何操作'
        'waitdays', '提交申请后等待天数'
        'other', '其他'
"content"提问内容


ResponseJson
成功：
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "msg": "申请成功！"
  }
}
失败：
{
    "msg": "申请失败！"
}



1.7.2 修改名称
请求URL
{base_url}/app_api/user/edit_user_name
edit_user_name
请求方式
POST

维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
        "user_name": "吴老板", //用户名称
         "app_version":"0.5.0", //app版本号
"method":"edit_user_name" //调用的函数
    },
    "method": "call",
    "id": 421974423
}
说明：需登录后进行操作

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 421974423,
    "result": {
        "msg": "修改名称成功",
        "data": {},
        "title": "修改用户信息成功"
    }
}
失败：
{
    "title": "修改用户信息错误",
    "error": "修改名称错误",
    "error_info": odoo系统错误
}
1.7.8 获取登陆用户名和密码
请求URL
{base_url}/app_api/user/login_message
get_login_message
请求方式
POST

维护者
毛涛

RequestJson
{
    "jsonrpc": "2.0",
"params": {
"method":"get_login_message", //调用的函数
"app_version":"0.5.0"//app版本号
            }
}
//随机返回一个结果

ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "records": [
            {
                "login_id": "1888888883",  //登陆用户账号
                "login_password": "123456" //登陆密码固定值
            },
        ]
    }
}

1.8 找回密码接口
请求URL
{base_url}/app_api/session/find_password
find_password
请求方式
POST

RequestJson
{

"params": {
"app_version":"0.5.0",//app版本号
"method":"find_password", //调用的函数
        "login":"18601611267",//账号手机号
        "newpassword":"111111",//新密码
       "code":"12345"//验证码
    }

}

ResponseJson
成功：
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {

               'msg':'修改密码成功，请重新登录','title': '找回密码'
 }
}
失败：
{'error':'该账号不存在.','title': '找回密码'                  }
说明：返回结果result中 有error的就是失败

1.9 业代维护终端用户信息接口
1.9.1 业代新增终端以及地址
请求URL
{base_url}/app_api/user/create
create_teminal_user
请求方式
POST

维护者
刘成德

RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
"params": {
"app_version":"0.5.0",//app版本号
"method":" create_teminal_user ", //调用的函数
                "cus_id":0,//终端的用户ID，创建可以不提供或者为0
            "cus_name":"大润发sb",//终端的用户名
            "cus_phone":"18601611267",//终端用户的手机号
"cus_telphone":"7764116",//固定电话
            "address_list":[      //终端用户端的地址列表
                {
                    "address_id":0,    //终端用户的地址id，
                    "address":"大润发sb1" //地址
"country_id":49,国家编号
                                                "state_id":410000,//省份编号
               "state_name":河南省,//省份名称                                 "city_id":410100,//城市编号
  "city":”郑州市”,//城市名,
                                                "county":410103,//县或者区编号
“county_name”:”二七区”//区县


                }

                ]



            }

}说明：需登录后进行操作，省、市县 必须提供，否则无法正确计算坐标

ResponseJson
成功：
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "address_ids": [
      152,   //新增的地址的id，其实就是 partnered

],
  "price_float": [
      10,   //新增的地址对应的 价格浮动区间
    ]

    "uid": 66   //新增的终端客户的 uid
  }
}失败：
odoo系统错误




1.9.2 业代更新终端信息
请求URL
{base_url}/app_api/user/update
update_teminal_user
请求方式
POST

维护者
孙洋

RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
"params": {
"app_version":"0.5.0",//app版本号
"method":" update_teminal_user ", //调用的函数
                "cus_id":66,//终端的用户ID，创建可以不提供
            "cus_name":"大润发sb",//终端的用户名
            "cus_phone":"18601611267",//终端用户的手机号
"cus_telphone":"7764116",//固定电话

            "address_list":[      //终端用户端的地址列表
                {
                    "address_id":152,    //终端用户的地址id，创建可以不提供或者为0
                    "address":"大润发sb1" //地址
                    “active”:true,//是否有效

                                                "state_id":123,//省份编号
               "state_name":河南省,//省份名称                                 "city_id":123,//城市编号
  "city":”郑州市”,//城市名,
                                                "county":123,//县或者区编号
“county_name”:”二七区”//区县


                }

                ]



            }

}说明：需登录后进行操作省、市县 必须提供，否则无法正确计算坐标

ResponseJson
成功：
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "address_ids": [//地址的返回顺序和提交到服务端的顺序一致
      152,   //新增的地址的id，其实就是 partnered

    ],
    "uid": 66   //新增的终端客户的 uid
  }
}失败：
odoo系统错误
1.9.3 业代获取终端列表
请求URL
{base_url}/app_api/user/terminal
get_saler_terminal
请求方式
POST

维护者
孙洋

RequestJson
{
"params": {
"app_version":"0.5.0",//app版本号
"method":"get_saler_terminal" //调用的函数
}
    "jsonrpc": "2.0",
    "method": "call",


}

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "records": [
            {
                "addresses": [
                    {
                        "city": "", //城市ID
                        "country_name": "中国",
                        "state_name": "", //省名称
                        "zip": "4683", //邮编
                        "phone": "123", //电话
                        "price_float":"1", //价格浮动区间
                        "type": "delivery", // 地址类型
                        "is_default": true, //是否默认地址
                        "id": 52, //地址ID
                        "county": "", //区县 iD
                        "mobile": "123", //手机
                        "street": "Rue Cesar de Paepe, 43", //街道
                        "city_name": "Vivegnis", //城市名称
                        "county_name": "", //区县名称
                        "active": true, //是否激活
                        "state_id": "", //省ID
                        "country": 49, //国家Id
                        "email": "123@sdfs.com",
                        "name": "123" //收货人名字
                    },
                    {
                        "city": "",
                        "country_name": "中国",
                        "state_name": "",
                        "zip": "4683",
                        "phone": "",
                        "type": "contact",
                        "is_default": true,
                        "id": 43,
                        "county": "",
                        "mobile": "17173",
                        "street": "Rue Cesar de Paepe, 43",
                        "city_name": "Vivegnis",
                        "county_name": "",
                        "active": true,
                        "state_id": "",
                        "country": 49,
                        "email": "demo.portal@yourcompany.example.com",
                        "name": "Demo Portal User"
                    }
                ],
                "mobile": "17173",
                "phone": "",
                "id": 6,
                "customer_name": "Demo Portal User"
            },
            {
                "addresses": [
                    {
                        "city": "",
                        "country_name": "中国",
                        "state_name": "",
                        "zip": "1123",
                        "phone": "123",
                        "type": "delivery",
                        "is_default": true,
                        "id": 53,
                        "county": "",
                        "mobile": "123123123",
                        "street": "aaatestesfd",
                        "city_name": "1132",
                        "county_name": "",
                        "active": true,
                        "state_id": "",
                        "country": 49,
                        "email": "123",
                        "name": null
                    },
                    {
                        "city": "",
                        "country_name": "中国",
                        "state_name": "",
                        "zip": "1123",
                        "phone": "123123",
                        "type": "contact",
                        "is_default": true,
                        "id": 3,
                        "county": "",
                        "mobile": "",
                        "street": "aaa",
                        "city_name": "1132",
                        "county_name": "",
                        "active": true,
                        "state_id": "",
                        "country": 49,
                        "email": "admin@yourcompany.example.com",
                        "name": "Administrator"
                    }
                ],
                "mobile": "", //手机
                "phone": "123123", //电话
                "id": 1, //客户user id
                "customer_name": "Administrator" //客户名称
            }
        ]
    }
}失败：
odoo系统错误
1.9.4 业代搜索终端列表
请求URL
{base_url}/app_api/user/terminalsearch
search_saler_terminal
请求方式
POST

维护者
孙洋

RequestJson
{
  "jsonrpc": "2.0",
  "method": "call",
  "params": {
"app_version":"0.5.0",//app版本号
"method":"search_saler_terminal", //调用的函数
"keyword": "Portal"，
“active”:1 //1代表只显示营业地址，0代表全部显示

"show_empty_address_company":0 //是否显示地址列表为空的终端公司(停业) 0,不显示，1显示
  }
}

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "records": [
            {
                "addresses": [
                    {
                        "city ": 0, //int,0代表空值
                        "country_name": "中国",
                        "state_name": "",
                        "zip": "4683",
                        "phone": "123",
                        "price_float":"1",
                        "type": "delivery",
                        "is_default": true,
                        "id": 52,
                        "county": 0, //int,0代表空值
                        "mobile": "123",
                        "street": "Rue Cesar de Paepe, 43",
                        "city_name": "Vivegnis",
                        "county_name": "",
                        "active": true,
                        "state_id": 0, //int,0代表空值
                        "country_id": 49,
                        "email": "123@sdfs.com",
                        "name": "123",
"address_type": "terminal", //terminal终端用户自建，company业代为终端用户创建


                    }
                                          }
                ],
                "mobile": "17173",  //废弃暂时保留
                "phone": "", //废弃暂时保留
                "id": 6, //废弃暂时保留
                "customer_name": "Demo Portal User"，//废弃暂时保留
"company_phone": "13956666666", //终端公司电话

                "company_partner_id": 2072, //终端公司主partner_id
                "company_id": 342, //终端公司id
                "company_name": "好好活就" //终端公司名字

            }
        ]
    }
}失败：
odoo系统错误
1.9.5业代获取终端公司列表(客户列表)
请求URL
{base_url}/app_api/user/retailerlist
search_saler_retailer_list
请求方式
POST

维护者
孙洋

RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
"params": {
"app_version":"0.5.0",//app版本号
"method":"search_saler_retailer_list", //调用的函数
"keyword": "029556669988", //搜索关键字
        "limit": 20, //每页多少条
        "offset": 0 //从数据库记录的第多少条开始显示，起始值为0
    }
}

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "records": [
            {
                "company_create_date": "2016-10-28 06:03:06.393534", //公司创建时间
                "company_phone": "029556669988", //公司电话
                "company_partner_id": 3285, //公司主partner id
                "company_id": 658, //公司ID
                "company_name": "高境界看看" //公司名称
            },
            {
                "company_create_date": "2016-10-28 06:03:05.223982",
                "company_phone": "13011111111",
                "company_partner_id": 3268,
                "company_id": 653,
                "company_name": "风风火火"
            },
            {
                "company_create_date": "2016-10-28 06:03:04.544362",
                "company_phone": "15159409155",
                "company_partner_id": 3259,
                "company_id": 650,
                "company_name": "额呃呃呃"
            }        ]
    }
}失败：
odoo系统错误


1.9.6业代搜索终端列表(新)
请求URL
{base_url}/app_api/user/retailersearch
search_saler_retailer
请求方式
POST

维护者
孙洋

RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
"params": {
"app_version":"0.5.0",//app版本号
"method":"search_saler_retailer", //调用的函数
        "keyword": "029556669988", //搜索关键字
        "active": 1, //1代表只显示营业地址，0代表全部显示
        "limit": 20, //每页多少条
        "offset": 0 //从数据库记录的第多少条开始显示，起始值为0
    }
}

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "records": [
            {
                "state_name": "", //省
                "county": 310112, //区县ID
                "active": true, // 该地址是否停业
                "street": "赶紧看看", //街道
                "id": 3286, //地址id
                "company_phone": "029556669988", //终端公司电话
                "zip": "", //邮编
                "country_id": 49, //国家ID
                "company_id": 658, //终端公司ID
                "price_float": 10,// 浮动空间
                "company_name": "高境界看看", //终端公司名字
                "county_name": "", //区县名字
                "country_name": "中国", //国家名字
                "address_type": "terminal", //地址类型
                "type": "delivery",
                "email": "",
                "location": "121.232809,31.102358",//坐标
                "city": 310001, //城市ID
                "company_partner_id": 3285, //终端公司主partner_id
                "is_default": false, //是否默认
                "phone": "",
                "company_create_date": "2016-10-28 06:03:06.393534", //终端公司创建时间
                "city_name": "", //城市名字
                "cooperative_company_id": "", //合作经销商公司ID
                "name": "终端填写地址信息", //地址名字
                "mobile": "029556669988", //地址电话
                "state_id": 310000, //省ID
                "contact_name": "联系人隔壁老王"
            }
        ]
    }
}失败：
odoo系统错误





1.9.7 业代获取客户详情
请求URL
{base_url}/app_api/user/terminaldetail
get_terminal_detail
请求方式
POST

维护者
孙洋

RequestJson
{
  "jsonrpc": "2.0",
  "method": "call",
  "params": {
"app_version":"0.5.0",//app版本号
"method":"get_terminal_detail", //调用的函数
    "id": "6" //客户user id
  }
}

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "mobile": "17173",
"customer_name": "Demo Portal User"，
        "records": [
            {
                "city": "",
                "country_name": "中国",
                "state_name": "",
                "zip": "4683",
                "phone": "123",
                "is_default": true,
                "country_id": 49,
                "email": "123@sdfs.com",
                "county": "",
                "mobile": "123",
                "street": "Rue Cesar de Paepe, 43",
                "city_name": "Vivegnis",
                "county_name": "",
                "active": true,
                "state_id": "",
                "type": "delivery",
                "id": 52,
                "name": "123"
            },
            {
                "city": "",
                "country_name": "中国",
                "state_name": "",
                "zip": "4683",
                "phone": "",
                "is_default": true,
                "country_id": 49,
                "email": "demo.portal@yourcompany.example.com",
                "county": "",
                "mobile": "17173",
                "street": "Rue Cesar de Paepe, 43",
                "city_name": "Vivegnis",
                "county_name": "",
                "active": true,
                "state_id": "",
                "type": "contact",
                "id": 43,
                "name": "Demo Portal User"
            }
        ]

    }
}失败：
odoo系统错误
2.0 业代我的配送单、支付单、退货单个数接口
请求URL
{base_url}/app_api/user/mycount
dealer_count
请求方式
POST

维护者
刘成德

RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
"params": {
"app_version":"0.5.0",//app版本号
"method":" dealer_count " //调用的函数

            }

}说明：需登录后进行操作

ResponseJson
成功：
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "delivery_count": 5,//配送单个数（状态 assigned（生效）
    "payment_count": 5,//支付单个数 （状态：draft，
    "return_order_count": 0
  }
}失败：
odoo系统错误

2.1 业代获取附近店铺接口
请求URL
{base_url}/app_api/user/location_stores
location_stores
请求方式
POST

维护者
刘成德

RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
"params": {
"app_version":"0.5.0",//app版本号
"method":" location_stores ", //调用的函数
               "app_location":"121.232809,31.102358"//当前坐标 经度,纬度


            }

}说明：需登录后进行操作

ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "records": [
            {
                "addresses": [
                    {
                        "city ": 0, //int,0代表空值
                        "country_name": "中国",
                        "state_name": "",
                        "zip": "4683",
                        "phone": "123",
                        "price_float":"1",
                        "type": "delivery",
                        "is_default": true,
                        "id": 52,
                        "county": 0, //int,0代表空值
                        "mobile": "123",
                        "street": "Rue Cesar de Paepe, 43",
                        "city_name": "Vivegnis",
                        "county_name": "",
                        "active": true,
                        "state_id": 0, //int,0代表空值
                        "country_id": 49,
                        "email": "123@sdfs.com",
                        "name": "123",
"address_type": "terminal", //terminal终端用户自建，company业代为终端用户创建
"distance": 0, 距离


                    }
                                          }
                ],
                "mobile": "17173",  //废弃暂时保留
                "phone": "", //废弃暂时保留
                "id": 6, //废弃暂时保留
                "customer_name": "Demo Portal User"，//废弃暂时保留
"company_phone": "13956666666", //终端公司电话

                "company_partner_id": 2072, //终端公司主partner_id
                "company_id": 342, //终端公司id
                "company_name": "好好活就" //终端公司名字

            }
        ]
    }
}失败：
odoo系统错误

2.1.1 业代获取附近店铺接口（新）
请求URL
{base_url}/app_api/user/nearby_stores
nearby_stores
请求方式
POST

维护者
孙洋

RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
"params": {
"app_version":"0.5.0",//app版本号
"method":" nearby_stores ", //调用的函数
               "app_location":"121.232809,31.102358"//当前坐标 经度,纬度
              "active": 1, //1代表只显示营业地址，0代表全部显示

            }

}说明：需登录后进行操作

ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "records": [
            {
                "state_name": "", //省
                "county": 310112, //区县ID
                "active": true, // 该地址是否停业
                "street": "赶紧看看", //街道
                "id": 3286, //地址id
                "company_phone": "029556669988", //终端公司电话
                "zip": "", //邮编
                "country_id": 49, //国家ID
                "company_id": 658, //终端公司ID
                "price_float": 10,// 浮动空间
                "company_name": "高境界看看", //终端公司名字
                "county_name": "", //区县名字
                "country_name": "中国", //国家名字
                "address_type": "terminal", //地址类型
                "type": "delivery",
                "email": "",
                "location": "121.232809,31.102358",//坐标
                "city": 310001, //城市ID
                "company_partner_id": 3285, //终端公司主partner_id
                "is_default": false, //是否默认
                "phone": "",
                "company_create_date": "2016-10-28 06:03:06.393534", //终端公司创建时间
                "city_name": "", //城市名字
                "cooperative_company_id": "", //合作经销商公司ID
                "name": "终端填写地址信息", //地址名字
                "mobile": "029556669988", //地址电话
                "state_id": 310000 //省ID
                "distance": 0 //与业代的距离
                "contact_name": "联系人王"            }
        ]
    }
}失败：
odoo系统错误



2.2业代收款获取附近店铺
请求URL
{base_url}/app_api/user/location_stores_payment
location_stores_payment
请求方式
POST

维护者
刘成德

RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
"params": {
"method":" location_stores_payment ", //调用的函数
               "app_location":"121.232809,31.102358"//当前坐标 经度,纬度
              "app_version":"0.5.0"//app版本号

            }

}说明：需登录后进行操作

ResponseJson
成功：
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
        "records": [
            {
                          "state_name": "", //省
                "county": 310112, //区县ID
                "active": true, // 该地址是否停业
                "street": "赶紧看看", //街道
                "id": 3286, //地址id
                "company_phone": "029556669988", //终端公司电话
                "zip": "", //邮编
                "country_id": 49, //国家ID
                "company_id": 658, //终端公司ID
                "price_float": 10,// 浮动空间
                "company_name": "高境界看看", //终端公司名字
                "county_name": "", //区县名字
                "country_name": "中国", //国家名字
                "address_type": "terminal", //地址类型
                "type": "delivery",
                "email": "",
                "location": "121.232809,31.102358",//坐标
                "city": 310001, //城市ID
                "company_partner_id": 3285, //终端公司主partner_id
                "is_default": false, //是否默认
                "phone": "",
                "company_create_date": "2016-10-28 06:03:06.393534", //终端公司创建时间
                "city_name": "", //城市名字
                "cooperative_company_id": "", //合作经销商公司ID
                "name": "终端填写地址信息", //地址名字
                "mobile": "029556669988", //地址电话
                "state_id": 310000 //省ID
                "distance": 0 //与业代的距离
"payment_unpay_count": "0.00", //未付款金额
            }
        ]  }
}失败：
odoo系统错误


2.3业代收款搜索店铺
请求URL
{base_url}/app_api/user/terminalunpaidsearch
search_saler_unpaidterminal
请求方式
POST

维护者
孙洋

RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
"params": {
"method":" search_saler_unpaidterminal ", //调用的函数
        "app_version":"0.5.0"//app版本号
        "offset": 0, //记录位移，从数据库第几条开始读，第一条为0
        "limit": 80, //每页数量
"keyword":"su" //搜索关键词 可不传
        "partner_id":"0.5.0"//app版本号f


    },
    "id": 21853948 //可不填
}
说明：需登录后进行操作

ResponseJson
成功：
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
        "records": [
            {
                          "state_name": "", //省
                "county": 310112, //区县ID
                "active": true, // 该地址是否停业
                "street": "赶紧看看", //街道
                "id": 3286, //地址id
                "company_phone": "029556669988", //终端公司电话
                "zip": "", //邮编
                "country_id": 49, //国家ID
                "company_id": 658, //终端公司ID
                "price_float": 10,// 浮动空间
                "company_name": "高境界看看", //终端公司名字
                "county_name": "", //区县名字
                "country_name": "中国", //国家名字
                "address_type": "terminal", //地址类型
                "type": "delivery",
                "email": "",
                "location": "121.232809,31.102358",//坐标
                "city": 310001, //城市ID
                "company_partner_id": 3285, //终端公司主partner_id
                "is_default": false, //是否默认
                "phone": "",
                "company_create_date": "2016-10-28 06:03:06.393534", //终端公司创建时间
                "city_name": "", //城市名字
                "cooperative_company_id": "", //合作经销商公司ID
                "name": "终端填写地址信息", //地址名字
                "mobile": "029556669988", //地址电话
                "state_id": 310000 //省ID

"payment_unpay_count": "0.00", //未付款金额
            }
        ]  }
}失败：
odoo系统错误




2.4 业代根据手机号查询并新建终端
2.4.1 根据手机号或者电话搜索现有信息
请求URL
{base_url}//app_api/user/checkexist
check_exist_user
请求方式
POST

维护者
刘长郄

RequestJson
{
    "jsonrpc":"2.0，可不填",
    "method":"call，可不填",
"params":{
"app_version":"0.5.0",//app版本号
"method":" check_exist_user ", //调用的函数
        "cms_phone":"17081456509"
    }
}

字段名

字
类型

中文含义

特殊说明


cm_phone

str

手机号或者电话

‘17081456509’





ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "status": "in",
        "partner_id": 203,
        "user_id": 175
    }
}
}
字段名

字段类型

中文含义

特殊说明


status

str

状态

Isin状态说明：
In：在平台内，根据返回的user_id获取信息
Notin:不在平台内，新建用户
Other_role:在平台内，但是是其他角色，不能新建，提示用户
not_cooperative:在平台内，但是没有合作关系，可以建立合作关系


Partner_id

int

公司主partner_id




User_id

int

用户user_id








2.4.2 根据主partner_id获取用户信息
请求URL
{base_url}/app_api/user/get
get_user_message
请求方式
POST

维护者
刘长郄

RequestJson
{
    "jsonrpc":"2.0，可不填",
    "method":"call，可不填",
"params":{
"app_version":"0.5.0",//app版本号
"method":" get_user_message ", //调用的函数
        "partner_id":120,
        "active":"1"  #1获取正常,0获取所有
    }
}

字段名

字
类型

中文含义

特殊说明


Partner_id

str

上一接口返回的partner_id




Active

Int

是否全部数据

1：开业数据
0：全部数据（包含停业）





ResponseJson
{
    id = 1;
    jsonrpc = "2.0";
    result =     {
        mobile = 13100000006;
        name = "72\U4fbf";
        records =         (
                        {
                active = 1;
                "address_type" = company;
                "city" = 120001;
                "city_name" = "\U5929\U6d25\U5e02";
                "country_id" = 49;
                "country_name" = China;
                "county_id" = 120101;
                "county_name" = "\U548c\U5e73\U533a";
                email = "b2b@hollywant.com";
                id = 2744;
                "is_default" = 1;
                mobile = 13100000069;//联系电话
                name = "72\U4fbf";//店铺名称
                phone = "";
                "price_float" = 10;
                "state_id" = 120000;
                "state_name" = "\U5929\U6d25\U5e02";
                street = "that was a ";
                zip = "";
                contact_name = "刘成";//联系人
            },
                        {
                active = 1;
                "address_type" = company;
                "city" = 310001;
                "city_name" = "\U4e0a\U6d77\U5e02";
                "country_id" = 49;
                "country_name" = China;
                "county_id" = 310101;
                "county_name" = "\U9ec4\U6d66\U533a";
                email = "b2b@hollywant.com";
                id = 2743;
                "is_default" = 1;
                mobile = 13100000006;
                name = "72\U4fbf";
                phone = "";
                "price_float" = 10;
                "state_id" = 130000;
                "state_name" = "\U6cb3\U5317\U7701";
                street = "the only";
                zip = "";
            }
        );
    };
}

字段名

字段类型

中文含义

特殊说明


mobile

str

手机号




Name

Str

终端名称




records

list

创建的地址

Address_type为company为客户创建地址，该地址类型对于用户来说能编辑
Address_type为terminal为终端创建地址
















2.4.3 用户为终端添加地址
请求URL
{base_url}/app_api/user/add/address
add_user_address
请求方式
POST

维护者
刘长郄

RequestJson
{
    "jsonrpc":"2.0，可不填",
    "method":"call，可不填",
"params":{
"app_version":"0.5.0",//app版本号
"method":" add_user_address ", //调用的函数
            "cus_id":345,
            "partner_id":12,
            "address":{
                "address_type":”terminal”,
                "address_id":0,
                "city":34,
                "city_name":"连云港市",
                "state_id":45,
                "state_name":"江苏省",
                "county":34,
                "county_name":"东海县",
                "street":34,
                "mobile":342344,
                "city_name":"上海市",
                "country_id":49,
                "county_name":"东海县",
                "type":'delivery',
                "active":True,
                "is_default":False,
                "email":"sss@223.com",
                "phone":"12323232",
                "zip":"3344"

            }
}
}
字段名

字
类型

中文含义

特殊说明


Partner_id

str

上一接口返回的partner_id

主partner_id


Cus_is

nt

2.4.1接口返回的cus_id

用户id
可不填











address

地址信息



State_id:省id
City_id:城市id
County：县id
Street：街道
Mobile：联系方式

Address_type	string	地址类型：
terminal
company	终端地址和公司地址，
终端添加为terminal
业代添加为company






ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "address_id": 2736,
        "success": "保存成功.",
        "title": "讯息"
    }
}
字段名

字段类型

中文含义

特殊说明


Address_id

int

地址id



































2.4.4 创建新的终端功能
请求URL
{base_url}/app_api/user/company/create_new
teminal_user_company_create_new
请求方式
POST

维护者
刘长郄

RequestJson
{
    "jsonrpc":"2.0，可不填",
    "method":"call，可不填",
    "params":{
"app_version":"0.5.0",//app版本号
"method":"teminal_user_company_create_new", //调用的函数
{
                "name":"苏果超市一号店",
                "phone":"12345654332",
                " company_contact_name ":"王先生",
                "address":[
                        {
                            "address_id":0,
                "city":34,
                "city_name":"连云港市",
                "state_id":45,
                "state_name":"江苏省",
                "county":34,
                "county_name":"东海县",
                "street":34,
                "mobile":342344,
                "city_name":"上海市",
                "country_id":49,
                "county_name":"东海县",
                "type":'delivery',
                "active":True,
                "is_default":False,
                "email":"sss@223.com",
                "phone":"12323232",
                "zip":"3344",
                "contact_name":"王小姐",
                "name":"地址店铺名"

                        }
                    ]
            }
}
}
字段名

字
类型

中文含义

特殊说明


name

str

店铺名称




phone

str

电话

默认手机号


company_contact_name

str

公司联系人




address

list

地址列表







ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "partner_id": 2738,
        "address_id": 2740,
        "user_id": 545,
        "success": "保存成功.",
        "title": "讯息"
    }
}
字段名

字段类型

中文含义

特殊说明











































2.4.5 地址停业功能
请求URL
{base_url}/app_api/user/address/stop
user_address_stop
请求方式
POST

维护者
刘长郄

RequestJson
{
    "jsonrpc":"2.0，可不填",
    "method":"call，可不填",
"params":{
"app_version":"0.5.0",//app版本号
"method":" user_address_stop ", //调用的函数
             "address_id":45,
             "active":0  #0 停业， 1 开业
            }
}


字段名

字
类型

中文含义

特殊说明


Address_id

int

地址id




active

int

O,1

0:停业
1：开业





ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "success": "保存成功.",
        "title": "讯息"
    }
}

字段名

字段类型

中文含义

特殊说明











































2.4.6 修改地址功能
请求URL
{base_url}/app_api/user/address/update
user_address_update
请求方式
POST

维护者
刘长郄

RequestJson
{
    "jsonrpc":"2.0，可不填",
    "method":"call，可不填",
"params":{
"app_version":"0.5.0",//app版本号
"method":" user_address_update ", //调用的函数
            address:{
                "address_id":0,
                "city":34,
                "city_name":"连云港市",
                "state_id":45,
                "state_name":"江苏省",
                "county":34,
                "county_name":"东海县",
                "street":34,
                "mobile":342344,
                "city_name":"上海市",
                "country_id":49,
                "county_name":"东海县",
                "type":'delivery',
                "active":True,
                "is_default":False,
                "email":"sss@223.com",
                "phone":"12323232",
                "zip":"3344",
                "contact_name":"王小姐",
                "name":"地址店铺名"

            }
            }
}


字段名

字
类型

中文含义

特殊说明


Address_id

int

地址id




mobile

str

电话




State_id

int

省id




City

int

市id




county

int

县d




street

int

街道
















ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "success": "保存成功.",
        "title": "讯息",
        “address_id”:15
    }
}

字段名

字段类型

中文含义

特殊说明











































2.4.7 为已经在平台内用户建立合作关系
请求URL
{base_url}/app_api/user/build/cooperative
build_cooperative_company
请求方式
POST

维护者
刘长郄

RequestJson
{
    "jsonrpc":"2.0，可不填",
    "method":"call，可不填",
"params":{
"app_version":"0.5.0",//app版本号
"method":" build_cooperative_company ", //调用的函数
            "partner_id":1230,
            "address":[{
                        "address_id":0,
                "city":34,
                "city_name":"连云港市",
                "state_id":45,
                "state_name":"江苏省",
                "county":34,
                "county_name":"东海县",
                "street":34,
                "mobile":342344,
                "city_name":"上海市",
                "country_id":49,
                "county_name":"东海县",
                "type":'delivery',
                "active":True,
                "is_default":False,
                "email":"sss@223.com",
                "phone":"12323232",
                "zip":"3344"
                }]
            }
}


字段名

字
类型

中文含义

特殊说明


partner_id

int

主partner_id




address

list

地址列表

里面字段按照标准格式，参照上面示例


















































ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "address_id": 2741,
        "success": "保存成功.",
        "title": "讯息"
    }
}
字段名

字段类型

中文含义

特殊说明











































2.4.8 终端公司更新终端信息
请求URL
{base_url}/app_api/terminal/update/name
terminal_update_name
请求方式
POST

维护者
刘长郄

RequestJson
{
    "jsonrpc":"2.0，可不填",
    "method":"call，可不填",
"params":{
"app_version":"0.5.0",//app版本号
"method":" terminal_update_name ", //调用的函数
            {
            "partner_id":123  #主partner_id
            "name":"经销商商户001",
            "phone":"终端手机号"
        }
            }
}


字段名

字
类型

中文含义

特殊说明


partner_id

int

主partner_id




name

string

公司名称




phone

string

手机号











































ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "partner_id": 123,
        "success": "保存成功.",
        "title": "讯息"
    }
}
字段名

字段类型

中文含义

特殊说明












































2、产品相关接口
2.1 查询产品列表
请求URL
{base_url}/app_api/dataset/search_read_product

请求方式
POST

维护者
居福国

RequestJson
{
    "jsonrpc":"2.0，可不填",
    "method":"call，可不填",
    "params":{
        "context":{
            "lang":"es_ES",
            "tz":"Europe\/Madrid",
            "uid":6
        },
        "model":"product.template   必填",
"offset":0,
        "limit":5,
        "search_type":"refund",
"categ_id": 1,
"brand_id": 6,
"product_name":"牛奶",
        "sort":"profit_rate desc"
    }
}

说明： model: 此处为 product.template
      offset: 定义返回数据从第几个开始
      limit：定义最多返回数据条数
search_type:定义筛选项
      sort：定义排序规则
字段名

字
类型

中文含义

特殊说明


model

String

此处为 product.template

必填


offset

int

返回数据从第几个开始

必填


limit

int

最多返回数据条数

必填


search_type

String

筛选项

选填，refund为促销


categ_id

int

分类id

选填，查询分下所有品


productname

String

产品名称查询

选填，根据产品名称，模糊查询


sort

String

排序规则

选填，按利润率排序profit_rate desc；按销量排序：sales_count desc


brand_id

int

品牌id







ResponseJson
{
   "jsonrpc": "2.0",
   "id": null,
   "result": {
      “isCarSaler = False”
      "records": [
         {
            "product_policy": {
               "date_end": "",
               "date_start": "",
               "policy_name": "",
               "policy_icon": "",
               "policy_type": "discount",
               "min_quantity": 1
            },

            "original_price": 750,
            "product_specification": "",
            "sale_ok": true,
            "product_unit": "Unit(s)",
            "variants": [
               [
                  "Memory",
                  "16 GB",
                  "32 GB"
               ],
               [
                  "Color",
                  "White",
                  "Black"
               ],
               [
                  "Wi-Fi",
                  "2.4 GHz"
               ]
            ],
            "price": 600,
            "image_small": "http://myvhost.com:8069/web/binary/image?model=product.template&id=6&field=image_medium&updatetime=1456110281",
            "msrp_price": 0,

            "rate": 0,
            "sales_count": 1,
            "product_options": [
               {
                  "original_price": 750,
                  "price": 600,
                  "product_id": 6,
                  "product_attr": [
                     "16 GB",
                     "White"
 “product_stock_qty”：200，
                  ]
               },
               {
                  "original_price": 750,
                  "price": 600,
                  "product_id": 7,
                  "product_attr": [
                     "16 GB",
                     "Black"
 “product_stock_qty”：200，
                  ]
               },
               {
                  "original_price": 800.4,
                  "price": 640.32,
                  "product_id": 8,
                  "product_attr": [
                     "32 GB",
                     "White"
                  ]
               }
            ],
            "id": 6,
            "name": "iPad Retina Display"
         }
      ]
   }
}
字段名

字段类型

中文含义

特殊说明


product_stock_qty

Int

可用商品量

Iscarsale=true会显示数量
=false 则数量默认都是0,


isCarSaler

String

是否车销销售

True 是车销


name

String

产品名称




sale_ok

boolean

是否可销售




image_small

String

图片地址

为空则无图片


id

int

产品id




pirce

floa

销售价格

如有优惠则为优惠后价格，前端显示为进价


list_pice

float

展示价格




msrp_price

float

建议销售价

前端显示为零售价


variants

array

产品系列

每个数组是一个系列。数组第一个元素为系列名称，其余元素为系列的值。



rate

flat

利润率




product_unit

String

计量单位




sales_count

int

已销量




policy_name

String

促销名称




policy_icon

String

促销类型图标




policy_type

String

促销类型

discount折扣促销
fullcut 满减
gifts 买赠


date_start

String

促销起始日期




date_end

String

促销结束日期








2.2 商品详情接口
请求URL
http://127.0.0.1:8069/app_api/product/{product_id}
例如：http://127.0.0.1:8069/app_api/product/77

请求方式
POST

RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
"id": 0
"params":{
       "image_size":"500x500"//不传该参数，默认 300x300

   }
}

ResponseJson
有可选商品属性;
{
    "jsonrpc": "2.0",
    "id": 21853948,
    "result": {
        "original_price": "10.00", //原始价格
"product_specification": "" //产品规格
         “brand”:”” //商品品牌
        "name": "odooAPI吸吸冰", //商品名称
"sale_ok": true, //是否可销售
        "weight": 0,
        "product_unit": "箱", //商品单位
        "categ_id": 1, //目录ID
        "price": "10.00", //销售价格
        "image_small": "http://localhost:8069/web/image/product.template/123/image/300x300", //图片
        "price_policies": [  //商品促销信息
            {
                "policy_type": "discount", //折扣类型
                "policy_name": "折扣优惠水蜜桃"
//折扣名字            },
            {
                "policy_type": "gifts",
                "policy_name": "买10小水蜜桃送1个ipad"
            }

        ],
        "categ_path": "All", //商品目录
        "sales_count": 0, //销售数量
        "qty_available": 0, //可销数量
        "product_options": [
            {
                "original_price": "10.00",  //option原价
                "price": "9.00", //option销售价格
                "product_id": 130,//传递给添加购物车的商品ID
"product_stock_qty": 10,  //当前商品车销库存数量
“product_qty”:2 //当前商品购物车里面的数量
                "product_attr": [ //可选择的商品属性
                    "White",
                    "水蜜桃"
                ]
            },
            {
                "original_price": "10.00",
                "price": "8.00",
                "product_id": 131,
                "product_attr": [
                    "Black",
                    "葡萄"
                ]
            }

        ],
        "id": 123, //商品模板ID
不可以用来传递给添加购物车
        "description": "暗室逢灯商品1"//商品描述
    }
}

没有商品可选择商品属性
{
    "jsonrpc": "2.0",
    "id": 21853948,
    "result": {
        "original_price": "47.00",
        "name": "Apple Wireless Keyboard",
        "weight": 0,
        "product_unit": "Unit(s)",
        "categ_id": 6,
        "price": "37.60",
        "image_small": "http://localhost:8069/web/image/product.template/12/image/300x300",
        "categ_path": "All / Saleable / Physical",
        "sales_count": 0,
        "qty_available": 22,
        "product_options": [
            {
                "original_price": "47.00",
                "price": "37.60",
                "product_id": 15,
                "product_attr": []
            }
        ],
        "id": 12, //商品模板ID
不可以用来传递给添加购物车
        "description": "The sleek aluminium Apple Wireless Keyboard.\n            "
    }
}







2.3 分类名称列表接口
请求URL
{base_url}/app_api/catepory/catepory_list
刘波
请求方式
POST
参数parent_id说明
父节点编码

RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
"id": 21853948 //请求序列ID，可不填
"params":{
  "brand_id":1 //品牌id,可不填
}
}

ResponseJson
{
  "jsonrpc": "2.0",
  "id": null,
  "result":  {
   "records": [
    {
      "count": 0,
      "child_id": [
        {
          "count": 1,
          "child_id": [],
          "image_small": "http://localhost:8069/web/image/product.category/9/image/300x300/20160129054419",
          "name": "旺仔牛奶",
          "id": 9
        }
      ],
      "image_small": "http://localhost:8069/web/image/product.category/2/image/300x300/20160129054341",
      "name": "牛奶",
      "id": 2
    },
    {
      "count": 0,
      "child_id": [],
      "image_small": "http://localhost:8069/web/image/product.category/6/image/300x300/20160129054014",
      "name": "干货",
      "id": 6
    },
    {
      "count": 0,
      "child_id": [],
      "image_small": "http://localhost:8069/web/image/product.category/7/image/300x300/20160129054029",
      "name": "仙贝",
      "id": 7
    },
    {
      "count": 0,
      "child_id": [],
      "image_small": "http://localhost:8069/web/image/product.category/8/image/300x300/20160129054351",
      "name": "饮料",
      "id": 8
    }
  ]
}

字段名

字段类型

中文含义

特殊说明


id

int

分类id




name

String

分类名称




count

String

分类商品数量




image_small

String

图片地址








2.4 分类下商品列表接口(废除，合并至2.1查询产品列表)
请求URL
{base_url}/app_api/catepory/catepory_product_list

请求方式
POST
参数sort_type说明
('list_price'),价格
参数
sort_mod说明
desc,asc

RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
    "params": {
        "categ_id":4, //分类id，可不填
        "sort_type": "list_price", //排序类别，可不填默认按价格
        "sort_mode": "desc",  //排序方式,可不填
        "offset": 0, //从数据库中第几条开始取数据,默认0
        "limit": 10 //每页显示几条，默认10
    },
    "id": 21853948 //请求序列ID，可不填
}

ResponseJson
{
  "jsonrpc": "2.0",
  "id": 21853948,
  "result": {
    "records": [
      {
        "list_price": 180,
        "price":180,
        "image_small": "",
        "sales_count": 0,
        "id": 3,
        "name": "外部审计"
      },
      {
        "list_price": 90,
        "price":90,
        "image_small": "",
        "sales_count": 0,
        "id": 1,
        "name": "预付咨询"
      },
      {
        "list_price": 38.25,
        "price":38.25,
        "image_small": "http://localhost:8069/website/image/product.template/4_1234567/image/300x300",
        "sales_count": 0,
        "id": 4,
        "name": "维护合同 ( 基于时间表 )"
      },
      {
        "list_price": 30.75,
        "price":180,
        "image_small": "http://localhost:8069/website/image/product.template/2_1234567/image/300x300",
        "sales_count": 0,
        "id": 2,
        "name": "差异分析服务"
      }
    ],
    "length": 4
  }
}

字段名

字段类型

中文含义

特殊说明


id

int

产品id




nae

String

产品名称




price

foat

销售价格1

暂定2个


list_price

float

销售价格2




image_small

String

图片地址




sales_out

in

已销售数量

















2.5 条形码跳转到商品详情
请求URL
{base_url}/app_api/product/barcode

请求方式
POST





RequestJson
{
 "jsonrpc": "2.0",
  "method": "call",
  "params": {
    "barcode": "1233", //条码
"image_size":"500x500" //图片大小
  }

}

ResponseJson
找不到：
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "msg": "未找到该条码对应的商品",
    "barcode": "1233"
  }
}

找到:
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "original_price": "1.00",
        "name": "旺旺果冻",
        "weight": 0,
        "product_unit": "件",
        "categ_id": 1,
        "price": "1.00",
        "image_small": "http://localhost:8069/web/image/product.template/6/image/500x500?unique=0654eec",
        "price_policies": [
            {
                "policy_icon": "",
                "policy_type": "discount",
                "policy_name": ""
            }
        ],
        "categ_path": "All",
        "sales_count": 0,
        "qty_available": 0,
        "product_options": [
            {
                "original_price": "1.00",
                "price": "1.00",
                "product_id": 6,
                "product_attr": []
            }
        ],
        "id": 6,
        "description": ""
    }
}

字段同商品详情接口












2.6 猜你喜欢
请求URL
{base_url}/ app_api/product/guessyoulike

请求方式
POST

维护者
杨绪栋

RequestJson
{
    "jsonrpc":"2.0, //可不填"
"method":"call, //可不填"
"id": 21853948,  //请求序列ID，可不填
}

ResponseJson
{
  "jsonrpc": "2.0",
  "id": 21853948,
  "result": {
 “isCarSaler = False”

    "records": [
      {
        "product_policy": {},
        "original_price": 79,
        "product_specification": "",
        "sale_ok": true,
        "product_unit": "Unit(s)",
        "price": 79,
        "image_small": "http://localhost:8069/web/binary/image?model=product.template&id=10&field=image_medium&updatetime=1460425228",
    “product_stock_qty”：200，

        "msrp_price": 0,
        "rate": 0,
        "sales_count": 0,
        "product_options": [
          {
            "original_price": 79,
            "price": 79,
            "product_id": 13,
            "product_attr": []
          }
        ],
        "id": 10,
        "name": "Apple In-Ear Headphones"
      }
    ]
  }
}
字段名

字段类型

中文含义

特殊说明


product_stock_qty

Int

可用商品量

Iscarsale=true会显示数量
=false 则数量默认都是0,


isCarSaler

String

是否车销销售

True 是车销


name

String

产品名称




sale_ok

boolean

是否可销售




image_small

String

图片地址

为空则无图片


id

int

产品id




price

float

销售价格

如有优惠则为优惠后价格，前端显示为进价


original_price

float

展示价格




msrp_price

float

建议销售价

前端显示为零售价


rate

float

利润率




product_unit

String

计量单位




sales_count

int

已销量




qty_available

Int

库存数量




Product_specification

String

产品规格




policy_name

String

促销名称




policy_icon

String

促销类型图标




policy_type

String

促销类型

discount折扣促销
fullcut 满减
gifts 买赠


Product_options

Dict






Original_price

float

展示价格




price

Float

销售价格




Product_id

int

产品id




Product_attr

List

可选的商品属性

字符串列表。参见商品详情列表


te_star

String

促销起始日期




ate_end

String

促销结束日期












2.7 商品车销库存接口
请求URL
http://127.0.0.1:8069/app_api/product/productcarqty
例如：http://127.0.0.1:8069/app_api/product/productcarqty

请求方式
POST
作者            孙洋
RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
    "id": 0,
    "params": {
        "product_id":6 //商品模板ID，product template id
    }
}

ResponseJson
{
   "jsonrpc": "2.0",
   "id": 0,
   "result": [
      {
         "product_stock_qty": 10,//当前车销仓库库存
         "product_id": 6, //商品口味ID
         "product_attr": [
            "16 GB", //属性值 口味等
            "White"
         ]
      },
      {
         " product_stock_qty ": 9,
         "product_id": 7,
         "product_attr": [
            "16 GB",
            "Black"
         ]
      },
      {
         " product_stock_qty": 8,
         "product_id": 8,
         "product_attr": [
            "32 GB",
            "White"
         ]
      },
      {
         " product_stock_qty": 6,
         "product_id": 9,
         "product_attr": [
            "32 GB",
            "Black"
         ]
      }
   ]
}




2.8 车销今日剩余库存


请求URL
{base_url}/ app_api/product/remaining_stock

请求方式
POST

维护者
毛涛

RequestJson
{
    }

ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
"result": {
   "records": [
        {
            "specification": "",
"product_uom_name":"Unit(s)",
            "product_options": [
                {
                    "product_attr": []
                }
            ],
            "name": "Laptop E5023",
            "product_qty": 16
        }
]
}
}
字段名

字段类型

中文含义

特殊说明


name

String

产品名称




product_uom_name

String

单位




specification

text

商品规格




product_stock_qty

String

剩余库存




Product_attr

List

可选的商品属性

字符串列表。参见商品详情列表




2.9 商品可销售的单位接口
请求URL
{base_url}/app_api/product/product_uom

请求方式
POST
刘成德

RequestJson
{
    "params":{
       "tmpl_id":129 //产品的模板ID,必填
       "partner_id":1 //某个终端的partnerID，如果不填写就用登录者对应的id

    }
}

ResponseJson
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
"company_info": {    //该产品所对应的公司信息
      "id": 1,
      "name": "YourCompany"
    },
    "records": [
      {
        "uom_type": "bigger",//比 reference 单位大
        "factor": 0.1,    //大的倍数  箱 * factor = reference
        "uom_default": true,//True 该商品的默认统计销售单位
        "id": 21,
        "name": "箱"
      },
      {
        "uom_type": "reference",//基本销售单位
        "factor": 1,
        "uom_default": false,
        "id": 20,
        "name": "包"
      },
      {
        "uom_type": "smaller",//比reference 单位小
        "factor": 10,  //小的倍数  根* factor = reference
        "uom_default": false,
        "id": 22,
        "name": "根"
      }
    ]
  }
}



订单相关接口
3.1 创建订单接口(功能已整合入购物车接口，此接口仅用于开发自测)
请求URL
{base_url}/app_api/dataset/create_order

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0", 可不填
    "params": {
        "model": "sale.order", 模型名称，必填
        "args": [
            {
                "cart_quantity": 1, 商品数量
                "name": "SO018", 订单名称
                "user_id": 1, 用户id
                "product_id": 4产品id
            }
        ],
        "method": "create"调用方法，必填
    },
    "method": "call", 调用方法，可不填
    "id": 471514862字符串，可不填
}

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 471514862,
"result": {
         "order_id":21成功创建的订单的id
       }
}
失败：{
}
说明： 暂时使用现有字段，



3.2 删除订单接口
请求URL
{base_url}/app_api/dataset/unlink_order

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
         "order_id" : 15 需要被删除的订单id，必填
    },
    "method": "call", 调用方法，可不填
"id": 14529748字符串，可不填
}



ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 832944217,
    "result": {
        "msg": "订单已删除"
        "title": "删除订单成功"
    }
}
失败：odoo系统级异常

说明：

3.3 订单列表接口
请求URL
{base_url}/app_api/order/list

请求方式
POST
作者
孙洋
       参数sort说明
sent_date desc：按时间最近
sent_date asc : 按时间最远
amount_total desc： 按照金额最大
amount_total asc:  按照金额最小
默认按照时间最近排序
参数status说明
(paid),已付款
(unpaid),未付款

('cancel'),取消
（no_cancel）排除已经取消的订单，用于今日总结

特别说明：在返回的列表中 会出现 process 这个状态，处理中。
不做为 入参
RequestJson

{
    "jsonrpc": "2.0",
    "method": "call",
    "params": {
        "status": "paid",//新需求只有3中，必填

        "offset": 0, //从数据库中第几条开始取数据
        "sort": "sent_date desc", //排序，请按照参数说明传递，可不传，但是不能传空值
        "limit": 80, //每页显示几条

        "timefrom": "2016-02-16 08:00:00", //可不传，但是不能赋空置，格式必须按照此示例格式
        "timeto": "2016-02-18 07:01:00",//可不传，但是不能赋空置，格式必须按照此示例格式

         "keyword": "SO010",  //搜索关键词，可能是客户名称、客户手机号、订单号，可不传，但是不能为空值，
             "customer_id":43 ,//指定客户ID，可以不传，但是不能传空值，也不能与keyword同时传，应用场景是从下拉客户列表里选择一个客户
         "belong": "self" //针对业代，传递此参数只显示此业代创建的订单，可以不传


    },
    "id": 21853948 //请求序列ID，可不填

}

ResponseJson
成功：{
    "jsonrpc": "2.0",
    "id": 21853948,
    "result": {
        "records": [
            {
                "price_poilicies": {}, //优惠促销信息

"order_number": "SO006", //订单号码
                "state": "sale", //订单状态
                "user_name": "Think Big Systems", //客户名称
                "invoice_status": "to invoice", //发票状态
                "date_order": "2016-01-07 00:00:00", //订单日期
                "order_goods_number": 1 //订单中商品总数量
                "id": 6, //订单ID
                "amount_total": 750 //订单总金额
                “is_carsales”：true/false //车销标示
            },
            {
                "order_number": "SO007",
                "state": "sale",
                "user_name": "China Export", //店铺名称
                "invoice_status": "to invoice",
"sent_date ": "2016-01-14 08:00:00",  //用户确认订单时间
"confirm_date ": "2016-01-14 08:00:00",  //经销商确认订单时间
                "id": 7,
                "amount_total": 14981,
"delivery_order": [
               {
                  "product_uom_qty": 1, //送货数量
                  "sum_price": 320, //送货总价
                  "images": [ //商品图片
                     "http://localhost:8069/web/image/product.template/9/image/300x300?unique=ed35737"
                  ],
                  "pick_name": "送货单1", //送货单名称
                  "delivery_order_state": "ready", //送货单状态
                  "picking_id": 24 //送货单ID
               }
            ],
            }
        ],
        "length": 2 //订单数
    }
}


3.4 取消订单接口
请求URL
{base_url}/app_api/order/cancel

请求方式
POST
作者
孙洋



RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
    "params": {
		"order_id":1 //需要取消的订单ID
       "delivery_id":1 //需要取消的送货单ID（仅限车销）
    },
    "id": 497381451 //请求序列ID，可不填
}

ResponseJson

成功：
{
"jsonrpc": "2.0"
"id": 497381451
"result": {
"msg": "成功取消订单！"
}
}

失败：
{
"jsonrpc": "2.0"
"id": 497381451
"result": 
{
"error": "取消订单失败！"
"title": "取消订单"
}

}



3.5 订单状态获取订单个数接口
请求URL
{base_url}/app_api/order/statuscount

请求方式
POST
作者
刘成德

参数status说明
('sent'),发送
('sale'),确定销售
('cancel'),取消
('done'),完成
('all'), 所有
RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
    "params": {
        "status":"sent", // 订单的具体状态或者all（所有的）,业代不要传all
    },
    "id": 21853948 //请求序列ID，可不填
}

ResponseJson
成功： {
  "jsonrpc": "2.0",
   "result": {
    "msg": "订单个数",
    "records": [
      {
        "count": 1,//个数
        "state": "sent"//状态
      },
      {
        "count": 2,
        "state": "sale"
      }
    ]
  }
}
失败：
{
  "jsonrpc": "2.0",
  "id": "",
  "result": {
    "error": "订单状态无效！"
  }
}

3.6 获取交易中订单个数接口
请求URL
{base_url}/app_api/order/transactionCount

请求方式
POST
      交易中订单现取：发送、销售、等待、手动、无需运送、无需发票
RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
    "id": 21853948 //请求序列ID，可不填
}

ResponseJson
{
  "jsonrpc": "2.0",
  "id": 21853948,
  "result": {
    "msg": "交易中订单个数",
    "count": 3
  }
}


3.7 订单详情接口
请求URL
{base_url}/app_api/order/detail

请求方式
POST
作者
孙洋
       订单在取消状态下回返回：cancel_user


RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
    "params": {
		"order_id":17 //订单ID
    },
    "id": 497381451 //请求序列号，可不填
}

ResponseJson
成功：{
"jsonrpc": "2.0"
"id": 497381451
"result": {
due_amount_total：100.22 //应收金额
"cancel_user":"小李"
"note": false ,
“order_remarks”:”” //订单备注
"invoice_status": "no" //预留字段
"saler_name": "刘成德" //业代名字
saler_phone:业代电话
"shipping_method": "" //快递方式
"payment_method": "Wire Transfer" //支付方式
"invoice_count": 0 //预留字段
"partner_id": 55 //客户partner id 不是user id
“partner_name": "sunyang" //客户名称，不是收货人名字
"delivery_price": 0, //快递费用
"contact_name":"联系人王先生"
"price_poilicies": { //该订单的促销信息，数据结构与接口4.5 购物车订单价格计算一致，后期维护请参考那个接口文档
            "total": 500,
            "discount_total": 1200,
            "gift_items": [
                {
                    "product_name": "旺旺雪饼",
                    "product_id": 3,
                    "product_quantity": 1
                },
                {
                    "product_name": "Free delivery charges",
                    "product_id": 4,
                    "product_quantity": 3
                }
            ],
            "fullcut_items": [
                {
                    "policy_id": 5,
                    "policy_cut": 100,
                    "policy_name": "满500减100"
                }
            ]
        },
"amount_tax": 0 //税费
"state": "sent"  //订单状态
"shipping_address": {  //送货地址
"city": 0 //城市id
"country_name": "中国"
"state_name": "" //省名称
"zip": "12312"
"phone": "123123"
"type": "contact" //地址类型
"is_default": true  //是否默认
"country_id": 49 //国家ID
"id": 55 //地址id
"county": 0 //区县id
"mobile": ""
"street": "test"
"city_name": "123" //城市名字
"county_name": ""  //区县名字
"active": true
"state_id": 0 //省id
"email": sunyang@hollywant.com
"name": "sunyang" //收货人名字

}-
"warehouse": "YourCompany"  //仓库 预留字段
"amount_untaxed": 1240.32  //税前费用
"order_products": [
         {"barcode": “1111111”,//商品编码
            "product_specification": "", //商品规格
            "name": "iMac电脑", //商品名称
            "product_unit": "件", //商品单位
            "price": "1799.00", //商品单价
            "image_small": "http://localhost:8069/web/image/product.template/11/image/300x300?unique=f881371", //图片
            "subtotal": 23387, //小计
            "product_options": [ //属性（口味 ）
               {
                  "product_uom_qty_str": "  1打  1件", //数量
                  "attr": "" //属性值口味等
               }
            ]
         },
         {
            "product_specification": "2312*199",
            "name": "单位订单商品测试",
            "product_unit": "提",
            "price": "10.00",
            "image_small": "http://localhost:8069/web/image/product.template/132/image/300x300?unique=3764222",
            "subtotal": 610,
            "product_options": [
               {
                  "product_uom_qty_str": "  11提  2包",
                  "attr": "蜜桃 "
               },
               {
                  "product_uom_qty": "  10箱",
                  "attr": "葡萄 "
               }
            ]
         }
      ],
    "order_gift_products": [
            {
                "product_specification": "",
                "name": "USB 适配器",
                "product_unit": "件",
                "price": "18.00",
                "image_small": "http://localhost:8069/web/image/product.template/51/image/300x300?unique=a148920",
                "subtotal": 18,
                "product_options": [
                    {
                        "product_uom_qty_str": "  1件",
                        "attr": ""
                    }
                ]
            }
        ],
    "supplier_phone": "+1 555 123 8069", //供应商电话
      "supplier_name": "YourCompany",  //供应商名字
"sent_date ": "2016-01-14 08:00:00",  //用户确认订单时间
"confirm_date ": "2016-01-14 08:00:00",  //经销商确认订单时间
"order_number": "SO016" //订单号码
"id": 17 //订单ID
"amount_total": 1240.32  //订单总金额
}-
}

失败：{
"jsonrpc": "2.0"
"id": 497381451
"result": {
"error": "获取订单详情失败！"
}-
}
3.8 快速下单接口
请求URL
{base_url}/app_api/order/quickbuy

请求方式
POST
作者
孙洋



RequestJson
 {
    "jsonrpc": "2.0",
    "method": "call",
    "params": {
        "offset": 0, //从第几条记录开始取值，第一条记录为0
        "limit": 10, //每页请求的记录数，默认10

        "customer_id": 1, //客户user id 废弃
       "partner_shipping_id ": 1281, //所选择的地址ID，地址列表里层的id 必须传
        "company_id": 5,//经销商公司ID，业代可以不传，终端必须传

    }"id": 497381451
}


ResponseJson
{
    "jsonrpc": "2.0",
    "id": 497381451,
    "result": {
        "records": [
            {
                "sale_total": 2,  //本产品总计订购量
                "original_price": "47.00",//原始价格
"product_specification": ""  //产品规格
"image_small": http://localhost:8069/web/image/product.template/12/image/300x300?unique=f881371 //图片
                "name": "Apple Wireless Keyboard",//商品名称
                "product_unit": "Unit(s)", //商品单位
                "product_template_id": 12, //商品template_id
                "price": "37.60",  //商品实际价格
  "price_policies": [//商品促销信息

                    {
                        "policy_icon": "",
                        "policy_type": "discount",
                        "policy_name": "折扣优惠水蜜桃12"
                    }
                ],
                "id": 15, //商品id,传递给加入购物车
                "attr": "" //口味之类的属性值
            },
            {
                "sale_total": 2,
                "original_price": "10.00",
                "name": "odooAPI吸吸冰",
                "product_unit": "箱",
                "price": "9.00",
  "price_policies": [  //商品促销信息
                    {
                        "policy_icon": "",
                        "policy_type": "discount",
                        "policy_name": "折扣优惠水蜜桃12"
                    }
                ],
                "id": 132,
                "attr": "White 葡萄 " //口味之类的属性值
            }
        ],
        "length": 5  //总共订购过的商品数量
    }
}




3.9 订单送货列表接口(已作废)
请求URL
{base_url}/app_api/deliver/list

请求方式
POST
作者
刘波



RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
    "params": {
		  "order_number":  ""  //搜索条件，无则空串
     "offset": 0, //从数据库中第几条开始取数据
    "order_state": "all", //状态 （sale:未完成，done：完成，all） , 不填默认sale   ,
"self_search":"self"  /”all”; (“self”:我的，all:全部)
        "limit": 5, //每页显示几条

     },
    "id": 497381451 //请求序列号，可不填
}

ResponseJson



    {
        "jsonrpc": "2.0",
        "id": null,
        "result":
        {
            "length": 13,//符合条件的总条目
            "records":
            [
                {
                    "sent_date": "",
                    "order_id": 14, //订单编号
                    "order_number": "SO014",
                    "delivery_info": //送货信息
                    [
                        {
                            "date_done": "2016-04-08 21:34:44", //送达时间

                            "picking_id": 19, //送货单id

                           "state": "done", //配送状态(assigned：在途；  waiting：待发；  done:完成）(再次废除)

                            "date": "2016-04-08 00:38:41",//预计送达时间

                            "delivery_name": "D00013",//送货单名称

                            "delivery_state": "ready"//送货单状态（"ready"：待发，done: 送达；delivering:在途）(废除app上的显示效果)（重新启用）

                        },
                        {
                            "date_done": "2016-04-08 00:51:16",
                            "picking_id": 18,
                            "state": "done",
                            "date": "2016-04-08 00:38:41",
                            "delivery_name": "D00012",
                            "delivery_state": "ready"
                        }
                    ],

                  "picking_address":  //送货地址，同1.4.1
                   [
                    {
                        "county": 110101,
                        "name": "小厨娘",
                        "zip": "",
                        "city": 110100,
                        "mobile": "13111331113",
                        "county_name": "",
                        "country_id": 49,
                        "email": "b2b@hollywant.com",
                        "is_default": true,
                        "phone": "13123332123",
                        "street": "董村路",
                        "city_name": "",
                        "city_id": false,  //没有则不显示
                        "country_name": "中国",
                        "active": true,
                        "state_id": 110000,
                        "type": "contact",
                        "id": 45,
                        "state_name": ""
                    }
                ],
                "state": "sale",//订单状态
                "confirm_date": "",  //用户确认订单时间
                "sent_date": "",  //经销商确认订单时间
                 "user_name": "小厨娘"

                 }
            ]
        }
    }




3.10 订单送货详情接口
请求URL
{base_url}/app_api/deliver/info

请求方式
POST
作者
刘波



RequestJson
{
    "params": {
        "order_id": "14",   // 订单id,必填
        "picking_id": "19"   //送货单id，必填
    }
}
 因为多单位影响，现在关于价格和数量相关的内容均无效

ResponseJson
{
  "jsonrpc": "2.0",
  "id": null,
   "result": {
 "order_products": [
      {
        "product_specification": "",  //产品描述
        "name": "乐扣乐扣拉杆箱",  //品名
        "product_unit": "件",  //单位
        "price": "55.00",   //单价
        "image_small": "http://b2bdemo.hollywant.com:88/web/image/product.template/4237/image/300x300?unique=9466539",//商品图片
        "product_picking_sum": 0,  //单品应送数量
        "product_sum": 10, //单品订货总量
        “subtotal”:单商品总价

        "tmpl_uom": [  //产品的单位列表
请参考 2.9商品可销售的单位接口
          {
            "uom_type": "bigger",
            "factor": 0.08333333333333333,
            "uom_default": false,
            "id": 2,
            "name": "Dozen(s)"
          },
          {
            "uom_type": "reference",
            "factor": 1,
            "uom_default": true,
            "id": 1,
            "name": "Unit(s)"
          }
        ],

   "stock_move_lines": [
      {
        "limit_return_products": [
          {
            "product_id": 3,
            "product_uom_id": 1,
            "product_uom_name": "件",
            "product_qty": 4,
            "stock_move_id": 264,
            "product_name": "apple"
          }
        ],
        "product_specification": "",
        "image_small": "http://localhost:8069/web/image/product.template/3/image/300x300?unique=1bbc71c",
        "name": "apple"
      },
      {
        "limit_return_products": [
          {
            "product_id": 7,
            "product_uom_id": 1,
            "product_uom_name": "件",
            "product_qty": 2,
            "stock_move_id": 260,
            "product_name": "大苹果 (苹果味)"
          },
          {
            "product_id": 7,
            "product_uom_id": 2,
            "product_uom_name": "打",
            "product_qty": 3,
            "stock_move_id": 262,
            "product_name": "大苹果 (苹果味)"
          }
        ],
        "product_specification": "",
        "image_small": "http://localhost:8069/web/image/product.template/6/image/300x300?unique=fb95924",
        "name": "大苹果"
      }
],

        "price_policies":
         [
             {
              "policy_icon": "http://b2bdemo.hollywant.com:88/web/binary/image?model=sys.config&id=3&field=image&updatetime=1461639166",
               "policy_type": "fullcut",
               "policy_name": "劳动节特价满百减十"
              }
         ],

        "product_options": [
          {
"barcode": “111111”,//产品编码
            "product_id": "3",
            "product_uom_qty_price_list": [
              {
                "name": "箱",//单位
                "price_unit": 1,//该单位的 单价
                "factor": 0.1,
                "product_qty": 1,//该单位购买的个数
                "uom_type": "bigger",
                "uom_default": true,
                "id": 23//单位ID
              },
              {
                "name": "提",
                "price_unit": 0.1,
                "factor": 1,
                "product_qty": 2,
                "uom_type": "reference",
                "uom_default": false,
                "id": 25
              },
              {
                "name": "罐",
                "price_unit": 0,
                "factor": 10,
                "product_qty": 0,
                "uom_type": "smaller",
                "uom_default": false,
                "id": 24
              }
            ],

            "attr": "",
            "product_uom_qty_str": "  2.00打"
          }
        ],
      },
      {
        "product_specification": "",
        "name": "Ipad4",
        "product_unit": "件",
        "price": "11.00",
        "product_picking_sum": 15,
        "product_sum": 50,
        "product_options": [
          {
            "product_id": "3",
            "attr": "",
            "product_uom_qty_str": "  2.00打"
          }
        ],
      }
],
        "price_poilicies":  //促销政策

        {
            "gift_items":
            [
            ],
            "total": 1252.4,
            "fullcut_items":
            [
                {
                    "policy_icon": "http://b2bdemo.hollywant.com:88/web/binary/image?model=sys.config&id=3&field=image&updatetime=1461639166",
                    "policy_id": 3,
                    "policy_cut": 130,
                    "policy_name": "劳动节特价满百减十"
                }
            ],
            "fullcut_total": 130,
            "list_total": 1382.4
        }
  "order_return_products":   //送货退货详情，字段同3.13
        [
            {
                "product_specification": "125MLX4X9草莓",
                "name": "0泡果奶味饮料",
                "product_unit": "箱",
                "price": "68.40",
                "image_small": "http://localhost:8069/web/image/product.template/4237/image/300x300?unique=9466539",
                "product_picking_sum": 6,
                "product_sum": 6,
                "product_return_sum": 4,
                "price_policies":
                [
                    {
                        "policy_icon": "http://localhost:8069/web/binary/image?model=sys.config&id=1&field=image&updatetime=1461610348",
                        "policy_type": "discount",
                        "policy_name": "限时促销八折优惠！"
                    }
                ],
                "product_options":
                [
                   同详情
                ]
            }
        ],

"picking_state": "done",  //配送状态(assigned：在途；  waiting：待发；  done:完成）   （再次废除）
“amount_total”:1000,//订单总价

"sent_date": "", //以下同3.9
    "picking_products_sum": 15,     //应发产品总量
"order_number": "SO014",
"shipping_address": {  //送货地址
                "county": 110101,
                "name": "销售经理",
                "zip": "",
                "city": 110100,
                "mobile": "",
                "county_name": "",
                "country_id": 49,
                "email": "xiaoshou@want.com",
                "is_default": true,
                "phone": "",
                "street": "",
                "city_name": "",
                "city_id": false,
                "country_name": "",
                "active": true,
                "state_id": 110000,
                "type": "contact",
                "id": 6,
                "state_name": "",
                "contact_name": "联系人王先生"
            }
       ],    "delivery_name": "D00012",
“final_product_count”:70 ,送货单的左下角商品总数
    "order_products_sum": 60,  //订单产品总量
    "order_state": "sale",  //订单状态
"confirm_date": "2016-04-07 16:38:44",
"date_done": "2016-04-08 21:34:44",//送达时间

"date": "2016-04-08 00:38:41",//预计送达时间
"delivery_order_state": "ready"  //app送货状态
(废除app上的显示效果)（重启）

“has_return” :flase //  是否办理过退货
        "partner_name": "张无忌",
"saler_name": "刘成德" //业代名字
“canbecancel” ：true/false 是否可以取消
“is_carsales” :：true/false 是否车销订单

  }
}




3.11 订单送货确认接口
请求URL
{base_url}/app_api/deliver/confirm_deliver

请求方式
POST
作者
刘波



RequestJson
{
    "params": {
        "order_id": "14",  //订单id
        "picking_id": "19",   //送货单ID
    }
}

ResponseJson
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "success": "送货单已成功送达！"
  }
}




3.12 订单送货退回确认接口
请求URL
{base_url}/app_api/deliver/confirm_return_picking

请求方式
POST
作者
刘波



RequestJson
{
    "params": {
        "order_id": "14",  //订单id
        "picking_id": "19",   //送货单ID
        "confirm_products": [  //送货退回商品，如果没有可以不填，请在app端进行数据判定

{
      "product_id": 7,
      "product_qty": 1,
      "stock_move_id": 260,
    },
    {
      "product_id": 7,
      "product_qty": 1,
      "stock_move_id": 262,
    },
    {
      "product_id": 3,
      "product_qty": 0,
      "stock_move_id": 264,  //列表中有的，但是选择数量为0，也需要回传0

    }
        ]
"remarks": "what", //备注

    }
}

ResponseJson
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "success": "送货退回单确认成功！"
  }
}




3.13 订单送货退回详情接口
请求URL
{base_url}/app_api/deliver/return_picking_info（合并至详情）

请求方式
POST
作者
刘波



RequestJson
{
    "params": {
        "order_id": "14",  //订单id
        "picking_id": "19",   //送货单ID


    }
}

ResponseJson
{
//未特殊说明部分，字段同送货详情
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "return_picking_name": "R3-9", //退货单名称
    "order_products": [
      {
        "product_specification": "",
        "name": "乐扣乐扣拉杆箱",
        "product_unit": "件",
        "price": "55.00",
        "product_return_sum": 4, //单品退货总量
        "product_options": [
          {
            "qty_delivered": 30,
            "product_id": 1,
            "return_protduct_qty": 4, 单品退货量 （无则空）
            "attr": "数量"
          }
        ]
      },
      {
        "product_specification": "",
        "name": "Ipad4",
        "product_unit": "件",
        "price": "11.00",
        "product_return_sum": 2,
        "product_options": [
          {
            "qty_delivered": 10,
            "product_id": 7,
            "return_protduct_qty": 2,
            "attr": "64g "
          },
          {
            "qty_delivered": 0,
            "product_id": 6,
            "attr": "32g "
          }
        ]
      }
    ],
    "has_return": true,
"return_products_sum": 6,  //送货单退货总量
"return_date": "2016-04-13", //退回时间
"remarks": "what",
    "picking_address": [
      {
        "county": 110101,
        "name": "达达",
        "zip": "",
        "city": 110100,
        "mobile": "",
        "county_name": "",
        "country_id": 49,
        "email": "b2b@hollywant.com",
        "is_default": true,
        "phone": "",
        "street": "",
        "city_name": "",
        "country_name": "",
        "active": true,
        "state_id": 110000,
        "type": "contact",
        "id": 40,
        "state_name": ""
      }
    ]
  }
}





3.14 订单收款列表接口
请求URL
{base_url}app_api/website_sale/payment_list

请求方式
POST
作者
张蔚文



RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
"params": {
    "state": "open", // 收款状态, open:未完成, paid:已完成
    "scope": "dealer", // 订单范围, dealer:业代的, all: 所有
    "keyword": "SO032",
    "offset": 0,
    "limit": 10
},
    "id": 497381451 //请求序列号，可不填
}

ResponseJson
{
   "jsonrpc": "2.0",
   "id": null,
   "result": {
      "records": [
          {
            "order_name": "SO096",
            "shipping_address": {
               "state_name": "",
               "city_id": 0,
               "street2": "",
               "street": "",
               "county_id": 0,
               "city_name": "",
               "name": "zww_terminal",
               "mobile": "",
               "country_id": 0,
               "county_name": "",
               "country_name": "",
               "state_id": 0
            },
            "mobile": "",
            "phone": "",
            "order_id": 97,
            "invoice_name": [
               {
                  "invoice_type": "out_invoice",     // 发票类型
                  // out_refund: 退货发票, out_invoice: 销售发票
                  "invoice_id": 98,                // 发票ID
                  "invoice_amount": 320,          // 发票金额
                  "invoice_state": "未完成",        // 发票状态
                  "invoice_name": "INV/2016/0040" // 发票编号
               }
            ],
            "date_order": "2016-05-09 01:09:27",
            "user_name": "zww_terminal",
            "deliver_name": [
               "ABC/OUT/00048"
            ],
            "amount_total": 320
         }
      ],
      "journal_id": {
         "cash": 5,  // 付款方法：现金
         "bank": 6  // 付款方法：银行
      },
      "account_id": { // 差异过账的账号ID
         "112100": 34,
         "112200": 35,
         "112300": 36,
         "122100": 39,
         "220200": 63,
         "220300": 64,
         "224100": 69
      }
   }
}



3.15 订单收款登记接口
请求URL
{base_url}/app_api/website_sale/payment_register

请求方式
POST
作者
张蔚文



RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
"params": {
   “order_ids”: [1,2,3,4,5,6], // 订单ID
       “amount”: 124.23,       // 实际付款
       “comment”: “affasdfaf”,  // 备注
       “journal_id”: 7,         // 付款方法(可选)
       “payment_method_id”:1  // 付款类型(可选)
       “writeoff_account_id”:1  // 差异过账(可选)
     },
    "id": 497381451 //请求序列号，可不填
}
journal_id: 0表示自动分配，默认值为0
payment_method_id: 0表示自动分配，默认值为0
writeoff_account_id: 0表示自动分配，False表示不差异过账，默认为False

ResponseJson
{
   "jsonrpc": "2.0",
   "id": null,
   "result": {
      "payment": 14,  // Odoo收款表ID
      "register_payment": 23
   }
}

或

{
   "jsonrpc": "2.0",
   "id": null,
   "result": {
      "temp_payment": 10  //  临时表收款ID
   }
}



3.16 订单收款详情接口
请求URL
{base_url}/app_api/website_sale/payment_detail

请求方式
POST
作者
张蔚文



RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
    "params": {
       “payment_id”: 1  // 收款单据ID
     },
    "id": 497381451 //请求序列号，可不填
}

ResponseJson
{
   "jsonrpc": "2.0",
   "id": null,
   "result": {
      "comment": "",                     // 备注
      "amount": 1329.5,                  // 实收
      "name": "CUST.IN/2016/0086",       // 付款单编号
      "date": "2016-05-11",               // 付款日期
      "records": [
          {
            "order_id": 88,                     // 订单ID
            "order_name": "SO087",             // 订单编号
            "mobile": "13800001111",            // 手机
            "phone": "62531234",               // 电话
            "date_order": "2016-05-06 18:58:34",  // 订单日期
            "user_name": "zww_terminal",       // 客户名
            "amount_total": 320,               // 订单总额
            "shipping_address": {              // 送货地址
               "state_name": "上海市",
               "city_id": 0,
               "street2": "",
               "street": "虹五路",
               "county_id": 0,
               "city_name": "",
               "name": "zww_terminal",
               "mobile": "",
               "country_id": 49,
               "county_name": "",
               "country_name": "中国",
               "state_id": 310000
            },
            "invoice_name": [
               {
                  "invoice_type": "out_invoice",     // 发票类别
                  "invoice_id": 86,                // 发票ID
                  "invoice_line_count": 1,          // 发票商品数量
                  "invoice_state": "已付",          // 发票状态
                  "invoice_amount": 320,          // 发票金额
                  "invoice_name": "INV/2016/0026" // 发票编号
               }
            ],
            "deliver_name": [
               "ABC/OUT/00036"
            ],
         },
      ]
   }
}



3.17 订单收款列表接口(某个客户的)
请求URL
{base_url}app_api/website_sale/payment_customer_list

请求方式
POST
作者
张蔚文



RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
"params": {
    "user_id": 8,
      "offset": 0,    // 偏移量，默认为0
    "limit": 10    // 返回数量，默认为全部
},
    "id": 497381451 //请求序列号，可不填
}

ResponseJson
{
   "jsonrpc": "2.0",
   "id": null,
   "result": {
      "name": "zww_terminal",          // 客户名称
      "phone": "13812341234",
      "mobile": "123456",
      "country_id": 49,
      "country_name": "中国",
      "state_id": 310000,
      "state_name": "上海市",
      "county_id": 0,
      "county_name": "",
      "city_id": 0,
      "city_name": "",
      "street": "虹五路",
"street2': "",
"contact_name: "联系人"
      "records": [
         {
            "order_id": 113,           // 订单ID
            "invoice_name": [
               {
                  "invoice_type": "out_invoice",  // 发票类型: 收款
                  "invoice_id": 164,            // 发票ID
                  "invoice_line_count: 1,        // 商品数量
                  "invoice_amount_signed": 320  // 发票金额
               },
               {
                  "invoice_type": "out_refund",  // 发票类型: 退款
                  "invoice_id": 165,
                  "invoice_line_count": 1,
                  "invoice_amount_signed": -320
               }
            ],
            "date_order": "2016-05-20 17:52:02",  // 订单日期
            "amount_total": 0                  // 发票总金额
         },
      ],
      "account_id": {  // 差异过账的账号ID
         "112100": 34,
         "112200": 35,
         "112300": 36,
         "122100": 39,
         "220200": 63,
         "220300": 64,
         "224100": 69
      },
      "journal_id": {
         "cash": 13,  // 付款方法：现金
         "bank": 14  // 付款方法：银行
      },
   }
}



3.18 订单收款历史接口(某个客户的)
请求URL
{base_url}app_api/website_sale/payment_customer_history

请求方式
POST
作者
张蔚文



RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
"params": {
    "user_id": 8, //废弃
" company_partner_id":578 //终端公司主partner_id 只有登录身份为业代时传即可，终端用户不需要传
        "offset": 0,         // 偏移量，默认为0
    "limit": 10         // 返回数量，默认为全部
"app_version":"0.5.0"//app版本号
},
    "id": 497381451 //请求序列号，可不填
}

ResponseJson
{
   "jsonrpc": "2.0",
   "id": null,
   "result": {
      "name": "zww_terminal",          // 客户名称
      "phone": "13812341234",
      "mobile": "123456",
      "country_id": 49,
      "country_name": "中国",
      "state_id": 310000,
      "state_name": "上海市",
      "county_id": 0,
      "county_name": "",
      "city_id": 0,
      "city_name": "",
      "street": "虹五路",
"street2': ""，
"contact_name: "联系人"
      "records": [
         {
            "payment_id": 97,                        // 收款单据ID
            "payment_date": "2016-05-20",             // 收款日期
            "payment_name": "CUST.OUT/2016/0010",  // 收款单号
            "order_count": 3,                        // 订单数量
            "payment_user": "Administrator",           // 收款人
            "payment_amount": 320,                  // 实收
            "invoice_amount": -320                   // 总额
         },,
      ],
   }
}



3.19 创建自动售货机订单接口
请求URL
{base_url}/app_api/order/create_vending_order

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
    "partner_shipping_id": 2//收货地址id
     "products_by_qty": [
          {
            "product_id": 2,//产品id
            "product_qty": 3//产品数量
            "shelf_number": "22",//货架号，字符串
          },
         ],
     order_remarks: "麻烦快点配送",//订单备注
    },
    "method": "call",
    "id": 611504162
}


ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 273690510,
    "result": {
        "msg": "创建自动售货机订单成功",
        "order_name": "SO309",
        "order_id": 307,
        "title": "创建自动售货机订单成功"
    }
}

说明：

3.20 后续处理自动售货机订单接口
请求URL
{base_url}/app_api/order/deal_vending_order

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
    "order_id": 33,//订单id
    "operation": "done", //操作，支持两种操作
                          done: 支付成功完成订单
                          cancel: 取消订单
    "pay_method": "cash", //支付方式，支持四种支付方式
                          ('cash', 'Cash'),
                              ('bank', 'Bank'),
                              ('alipay', '支付宝'),
                              ('wechat', '微信支付')
    },
    "method": "call",
    "id": 611504162
}


ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 38910745,
    "result": {
        "msg": "自动售货机订单完成成功！",
        "title": "处理自动售货机订单"
    }
}
说明：

3.21 今日业绩
请求URL
{base_url}/app_api/order/getTodaySaleInfomation

请求方式
POST
       刘波


RequestJson
{
    "params":{
        "start_date":"2016-07-20 00:00:00",#注意日期的格式
        "end_date":"2016-07-20 23:59:59"

    }
}

ResponseJson


    {
        "jsonrpc": "2.0",
        "id": null,
        "result":
        {
            "sale_total": 6263.86,
            "sale_count": 2,
            "payment_total": 6403.86
        }
    }




3.22 业代今日总结-今日业绩
请求URL
{base_url}/app_api/order/getTodaySaleInfomation_list

请求方式
POST
       刘成德


RequestJson
{
    "params":{
        "start_date":"2016-07-20 00:00:00",#注意日期的格式
        "end_date":"2016-07-20 23:59:59"

    }
}

ResponseJson


    {
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "records": [
      {
        "sale_total": 320,//金额
        "product_specification": "",//规格
        "product_id": 12,//产品ID
        "sale_count": [//销售数量
          {
            "unit_name": "Unit(s)",
            "product_uom_qty": 1
          }
        ],
        "product_attr": [],//口味（属性列表）
        "name": "iPad Mini"//产品名
      }
    ]
  }
}


3.23 创建direct订单接口
请求URL
{base_url}/app_api/order/create_direct_order

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
        "partner_shipping_id": 2//收货地址id
        "products_by_qty": [
         {
            "product_id": 2,//产品id
            "product_qty": 3//产品数量
         },
         ],
     order_remarks: "麻烦快点配送",//订单备注
    },
    "method": "call",
    "id": 611504162
}


ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 273690510,
    "result": {
        "msg": "创建direct订单成功",
        "order_name": "SO309",
        "order_id": 307,
        "title": "创建direct订单成功"
    }
}

说明：

3.24 获取可送货退回的产品列表
请求URL
{base_url}/app_api/deliver/stock_move_lines

请求方式
POST



RequestJson
{
    "jsonrpc": "2.0",
    "params": {
        "picking_id”: 168

    },
    "method": "call",
    "id": 611504162
}


ResponseJson
{
  "jsonrpc": "2.0",
  "id": 497381451,
  "result": [
    {
      "product_id": 7,               //产品id
      "product_uom_id": 1,          //产品单位id
      "product_uom_qty": 2,         //该单位最大可退数量
      "product_uom_name": "件",    //单位名称
      "stock_move_id": 230,         //出货单id
      "product_name": "大苹果 (苹果味)"   //产品名
    },
    {
      "product_id": 7,
      "product_uom_id": 2,
      "product_uom_qty": 3,
      "product_uom_name": "打",
      "stock_move_id": 232,
      "product_name": "大苹果 (苹果味)"
    }
  ]
}


3.25 订单收款详情打印小票接口
请求URL
{base_url}/app_api/ website_sale/payment_detail_print

请求方式
POST
作者




RequestJson
{
    "jsonrpc": "2.0",
    "method": "call",
    "params": {
	"payment_id": 1  // 收款单据ID
    },
    "id": 497381451 //请求序列号，可不填
}

ResponseJson
成功：{
"jsonrpc": "2.0"
"id": 497381451
"result": {
"all_due_amount_total": 1240.32  //收款单应收总金额，订单金额相加
"all_amount_total"：100.22 ////收款单实收总金额
""records":": [
{
"shipping_method": "",
    "order_products": [
      {
        "product_specification": "80ml×10×4",
        "name": "80ml旺旺冰沙吸吸冰",
        "price": 0,
        "subtotal": 244,
        "product_options": [
          {
  "barcode": “123456”,//产品编码
            "attr": "酸梅味 ",
            "product_uom_qty_price_list": [
              {
                "name": "箱",
                "price_unit": 80,
                "product_qty": 1,
                "factor": 1,
                "uom_type": "reference",
                "id": 55
              },
              {
                "name": "包",
                "price_unit": 2,
                "product_qty": 1,
                "factor": 40,
                "uom_type": "smaller",
                "id": 56
              }
            ],
            "product_id": 55,
            "product_uom_qty_str": ""
          },
          {
            "attr": "香橙味 ",
            "product_uom_qty_price_list": [
              {
                "name": "箱",
                "price_unit": 80,
                "product_qty": 1,
                "factor": 1,
                "uom_type": "reference",
                "id": 55
              },
              {
                "name": "包",
                "price_unit": 2,
                "product_qty": 1,
                "factor": 40,
                "uom_type": "smaller",
                "id": 56
              }
            ],
            "product_id": 56,
            },
          {
            "attr": "悉尼味 ",
            "product_uom_qty_price_list": [
              {
                "name": "箱",
                "price_unit": 80,
                "product_qty": 1,
                "factor": 1,
                "uom_type": "reference",
                "id": 55
              }
            ],
            "product_id": 57,
            "product_uom_qty_str": ""
          }
        ]
      },
      {
        "product_specification": "1000ml*8",
        "name": "1000ml康师傅水蜜桃",
        "price": 0,
         "subtotal": 128,
        "product_options": [
          {
            "attr": "",
            "product_uom_qty_price_list": [
              {
                "name": "箱",
                "price_unit": 25,
                "product_qty": 5,
                "factor": 1,
                "uom_type": "reference",
                "id": 73
              },
              {
                "name": "瓶",
                "price_unit": 3,
                "product_qty": 1,
                "factor": 8,
                "uom_type": "smaller",
                "id": 74
              }
            ],
            "product_id": 347,
            "product_uom_qty_str": ""
          }
        ]
      }
    ],
    "delivery_price": "0.00",
    "saler_name": "SW引单",
    "order_gift_products": [],
     "sent_date": "2016-09-26 13:34:50",
    "due_amount_total": "100.00",
    "partner_id": 31,
    "id": 610,
    "order_remarks": "",
    "amount_untaxed": "372.00",
    "partner_name": "试用终端测",
    "confirm_date": "2016-09-26 13:34:50",
    "amount_tax": 0,
    "shipping_address": {
      "city": 310001,
      "country_name": "中国",
      "state_name": "上海市",
      "zip": "",
      "phone": "",
      "type": "contact",
      "is_default": true,
      "country_id": 49,
      "id": 31,
      "county": 310112,
      "mobile": "13816267083",
      "street": "虹许路558号",
      "city_name": "上海市",
      "county_name": "闵行区",
      "active": true,
      "state_id": 310000,
      "email": "b2b@hollywant.com",
      "name": "试用终端测"
    },
    "supplier_name": "SO160923563",
    "amount_total": "372.00",
    "supplier_phone": "",
"order_number": "SO160923563",
  }}
]
}

失败：{
"jsonrpc": "2.0"
"id": 497381451
"result": {
"error": "获取收款单打印详情失败！"
}-
}

3.26 今日业绩-今日业代收款列表
请求URL
{base_url} /app_api/b2b

请求方式
POST
       刘成德


RequestJson

{

 "params": {
                "method":"getDealerPaymentInfo",#需要调用的方法
               "start_date":"2016-07-20 00:00:00",#注意日期的格式
        "end_date":"2016-07-20 23:59:59"


            }

}


ResponseJson


   {
  "jsonrpc": "2.0",
  "id": null,
  "result": [
    {
      "payment_total": 1445, #某个业代的今日收款金额
      "id": 7, #终端的ID
      "name": "Agrolait" #终端名
    },
    {
      "payment_total": 320,
      "id": 3,
      "name": "Administrator"
    }
  ]
}





购物车相关接口
注意：购物车产品种类上限：30
      立即购买产品种类上限：30
4.1 确认购物车订单接口
请求URL
{base_url}/app_api/website_sale/confirm_cart_order

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
"params": {
"app_version":"0.5.0"//app版本号
        "partner_shipping_id": 2,//收货地址id，传入该参数则user_info参数失效
        "promotion_prices": {//购物车优惠价格接口返回的数据,用于优惠价格的确认
            "total": 11601.0,
            "discount_total": 0.0,
            "gift_items": [
                {
                    "policy_icon": "",
                    "product_quantity": 3,
                    "product_name": "iMac",
                    "product_attr": [],
                    "product_id": 14
                }
            ],
            "fullcut_items": []
        },
        "user_info": {//用户信息，在有partner_id的情况下不需要
            "city": "city", //城市（必需）
"street": "street", //街道1（必需）
            "street2": "street2", //街道2
            "country_id": 3, //国家id，需要统一odoo与app的国家id（必需）
            "phone": "051584353543",// 固话，必须带区号
            "mobile": "13245674356",// 手机（必需）
            "email": "aaa@email.com"//电子邮件，必须为电子邮件格式（必需）
        },
        "confirm_products": [//本次订单需要确认的产品列表,可不传,不传或为空时默认确认购物车中所有产品
            {
                "product_id": 13, //产品id
                "product_qty": 1,//确认的产品数目
                "product_uom":8045//产品单位id
                "is_gift":false//确认的产品是否为赠品
            }
        ] ,
        order_remarks: "麻烦快点配送",//订单备注
        longitude: 23.43, //经度,float类型,区间正负180
        latitude: 43.23 //纬度,float类型,区间正负90
            actual_amount: 180.0//实际支付金额，可不填，不填使用优惠计算接口价格
},
    "method": "call", 调用方法，可不填
"id": 14529748字符串，可不填
}

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 832944217,
    "result": {
        "msg": "订单已确认"
        "title": "确认订单成功",
        "data": {
            "order_id": 140,
"order_name": "SO126",
            "total": 561.6
        }
    }
}
失败：
{
    "jsonrpc": "2.0",
    "id": 734227581,
    "result": {
        "title": "确认订单错误",
        "error": "购物车不存在"
             或”购物车为空”
             或"交易进行中"
             或"用户信息错误"
             或"添加赠品失败"
             或"价格不一致"
        "error_info": 返回的错误信息
    }
}
{
    "jsonrpc": "2.0",
    "id": 238652829,
    "result": {
        "title": "确认订单错误",
        "error": "传入了购物车中不存在的商品",
        "error_info": {
            "product_id": 17889
        }
    }
}
{
    "jsonrpc": "2.0",
    "id": 940728981,
    "result": {
        "title": "确认订单错误",
        "error": " 确认商品数目错误",
        "error_info": {
            "product_id": 17,
            "product_qty": 1000
        }
    }
}
说明： 用户信息会随着订单属性的增加开放更多属性


4.2 更新购物车接口
请求URL
{base_url}/app_api/website_sale/update_cart

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
        "args": [//数组，设定产品id和数量
            {
"app_version":"0.5.0"//app版本号
                "product_id": 2, //产品id，必填
                "add_qty": 3,//需要增加的产品数量，与set_qty不可同时设置，可不设置，默认值None
                "set_qty": 3,//需要设定的产品数量，与add_qty不可同时设置，如被同时设置，优先set_qty，可不设置，默认值None
                "product_unit_price":10,//设定产品单位售价，app端不需使用，不传即可
                "product_uom":8045,//产品单位id
                “is_gift”:false//更新的产品是否为赠品
            },
        ],
        “is_gift”:false//更新的产品是否为赠品，兼容旧参数，上述数组参数中is_gift优先
    },
    "method": "call",
    "id": 611688784
}
说明：清空购物车与添加商品可同时进行，但数组中添加的商品必须放在清空的商品之后

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 611688784,
    "result": {
        "data": [//数组，返回结果
            {
                "line_id": 40, //产品所在order_line的id
                "product_id": 2,//产品id
                "quantity": 3//产品被修改后的数量
            },
            {
                "line_id": 41,
                "product_id": 3,
                "quantity": 4
            }
        ],
        "msg": "购物车已被更新"
        "title": "修改购物车成功"
    }
}
特殊情况：当减少产品使购物车为空时
{
    "jsonrpc": "2.0",
    "id": 832944217,
    "result": {
        "msg": "购物车已被清空"
        "title": "修改购物车成功"
    }
}
当部分产品不存在时，仍返回正确信息
{
    "jsonrpc": "2.0",
    "id": 129829976,
    "result": {
        "msg": "部分产品不存在",
        "data": [
            {
                "product_id": 1000,
                "error": "该产品不存在"
            },
            {
                "line_id": 93,
                "product_id": 2,
                "quantity": 24.0
            }
        ],
        "title": "修改购物车成功"
    }
}

失败：
{
    "jsonrpc": "2.0",
    "id": 734227581,
    "result": {
        "title": "修改购物车错误",
        "error": "订单已被确认",
"error_info": "订单确认后无法修改"
    }
}
{
    "jsonrpc": "2.0",
    "id": 414971339,
    "result": {
        "title": "修改购物车错误",
        "error": "产品均不存在",
"error_info": "产品均不存在"
    }
}



4.3购物车商品数量接口

请求URL
{base_url}/app_api/website_sale/cart_qty

请求方式
POST

维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {},
    "method": "call",
    "id": 488550581
}
说明：不需要任何参数


ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 488550581,
    "result": {
        "cart_qty": 4
    }
}
失败：
Odoo系统错误




4.3购物车详情接口
请求URL
{base_url}/app_api/website_sale/cart_detail
cart_call_kw
请求方式
POST
维护者
刘成德

RequestJson
{
    "jsonrpc": "2.0",
"params": {
"method":"cart_call_kw", //调用的函数
       "app_version":"0.5.0"//app版本号
    },
    "id":"1234" //请求序列号，可不填写
}


ResponseJson
成功：{
  "jsonrpc": "2.0",
  "id": "",  "id":"1234" //请求序列号
  "result": {
    "msg": "购物车为空",
    "title": "购物车为空"
  }
}
成功：{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "title": "购物车详情",
    "order_id": "30",
"cart_quantity": "9",//购物车商品数量
"msg": "购物车详情",
    "amount_total": "69.43"  总价格
"records_gift": [],   赠品详情 结构和 record一样
    "record": [
      {
        "original_price": "6.50",
        "description": "",
        "weight": 0,
        "image_small": "",
        "price": "6.18",
        “refund_price”:6.18 //优惠后的价格，用于区间控制
        #"qty_available": 0,去掉该字段
        "categ_id": 1,
        "id": 123,//产品模板ID
       "product_options": [
          {
            "original_price": "1.00",
            "product_uom_qty_price_list": [
              {
                "name": "箱",//单位
                "price_unit": 1,//该单位的 单价
                "factor": 0.1,
                "product_qty": 1,//该单位购买的个数
                "uom_type": "bigger",
                "uom_default": true,
                "id": 23//单位ID
              },
              {
                "name": "提",
                "price_unit": 0.1,
                "factor": 1,
                "product_qty": 2,
                "uom_type": "reference",
                "uom_default": false,
                "id": 25
              },
              {
                "name": "罐",
                "price_unit": 0,
                "factor": 10,
                "product_qty": 0,
                "uom_type": "smaller",
                "uom_default": false,
                "id": 24
              }
            ],
            "product_id": 140, //产品ID
            "product_uom": "提",//销售单位
            "price": "1.00",//销售单位 对应的价格
            "product_qty": 2,
            "product_attr": []
          }
        ],
        "name": "旺仔牛奶",
        "product_unit": "Unit(s)",
"product_specification": "10袋/箱",     //包装描述
  "categ_path": "All",
        "sales_count": 0
      }
    ],

  }
}说明： 这种情况是用public登录的提示



4.4 立即购买接口（废弃）
请求URL
{base_url}/app_api/website_sale/buy_it_now

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
"params": {
    "partner_shipping_id": 2//收货地址id，传入该参数则user_info参数失效
        "user_info": {//用户信息，在有partner_shipping_id的情况下不需要
            "city": "city", //城市（必需）
"street": "street", //街道1（必需）
            "street2": "street2", //街道2
            "country_id": 3, //国家id，需要统一odoo与app的国家id（必需）
            "phone": "051584353543",// 电话（必需）
            "mobile": "13245674356",// 手机
            "email": "aaa@email.com"//电子邮件，必须为电子邮件格式（必需）
        },
      "products_by_qty": [
          {
            "product_id": 2,//产品id
            "product_qty": 3//产品数量
            "product_unit_price": 23//需要修改的产品单价，如不需修改，不传即可
            "product_uom":8045//产品单位id
          }
        ],
        order_remarks: "麻烦快点配送",//订单备注
        longitude: 23.43, //经度,float类型,区间正负180
        latitude: 43.23 //纬度,float类型,区间正负90
    },
    "method": "call",
    "id": 611504162
}


ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 611504162,
    "result": {
        "msg": "立即购买订单已确认",
        "title": "立即购买成功",
        "data": {
            "order_id": 140,
"order_name": "SO126",
            "total": 561.6
        }
}

失败：
{
    "jsonrpc": "2.0",
    "id": 734227581,
    "result": {
        "title": "立即购买失败",
        "error": "确认立即购买订单失败"
    }
}
{
    "jsonrpc": "2.0",
    "id": 734227581,
    "result": {
        "title": "立即购买失败",
        "error": "创建立即购买订单失败"
    }
}

说明：


4.5 再次购买接口（废弃）
请求URL
{base_url}/app_api/website_sale/rebuy

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
"params": {
    "order_id": 2//订单id
    },
    "method": "call",
    "id": 611504162
}


ResponseJson
成功：
返回当前购物车详情，格式见购物车详情接口
失败：
{
    "jsonrpc": "2.0",
    "id": 734227581,
    "result": {
        "title": "再次购买失败",
        "error": "添加购物车产品失败",
        "error_info": 失败信息
    }
}
{
    "jsonrpc": "2.0",
    "id": 734227581,
    "result": {
        "title": "再次购买失败",
        "error": "获取购物车信息失败",
        "error_info": 失败信息
    }
}

说明：


4.6 购物车订单价格计算接口
请求URL
{base_url}/app_api/website_sale/compute_cart_price

请求方式
POST

维护者
居福国

RequestJson
{
  "params": {
    "products_by_quantity": [
      {
        "product_id": 2,
        "product_qty": 3
      },
      {
        "product_id": 3,
        "product_qty": 5
      }
    ]
  }
}
说明： 根据需要计算的产品填写多个产品与数量组合数据，如实例中计算两个产品的订单价格
products_by_quantity 字段可以不填，返回价格为0
字段名

字类型

中文含义

特殊说明


product_id

String

产品id

必填


product_qty

int

产品数量

必填





ResponseJson
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "gift_items": [
      {
        "product_id": 3,
        "product_name": "旺旺牛奶",
        "policy_icon": "web/binary/image?model=sys.config&id=4&field=image&updatetime=2016-02-01 06:58:28",
        "policy_names": "买二送一,买三送一",
        "product_quantity": 2,
        "product_attr": [
          "100ml",
          "苹果味"
        ]
      }
    ],
    "fullcut_total": 60,
    "discount_total": 116,
    "fullcut_items": [
      {
        "policy_icon": "web/binary/image?model=sys.config&id=3&field=image&updatetime=2016-02-01 06:55:16",
        "policy_name": "旺仔牛奶满500减50",
        "policy_cut": 50,
        "policy_id": 20
      },
      {
        "policy_icon": "web/binary/image?model=sys.config&id=3&field=image&updatetime=2016-02-01 06:55:16",
        "policy_name": "全场满100减10",
        "policy_cut": 10,
        "policy_id": 21
      }
    ],
    "total": 804,
    "discount_items": [
      {
        "policy_icon": "web/binary/image?model=sys.config&id=1&field=image&updatetime=2016-02-02 09:08:11",
        "discount_amount": 80,
        "policy_name": "旺旺牛奶9折",
        "policy_id": 9
      },
      {
        "policy_icon": "web/binary/image?model=sys.config&id=1&field=image&updatetime=2016-02-02 09:08:11",
        "discount_amount": 36,
        "policy_name": "旺旺苹果味8折",
        "policy_id": 18
      }
    ],
    "list_total": 980
  }
}

如果请求参数类型错误返回如下：
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "error": "请求参数类型错误！",
    "title": "购物车价格计算"
  }
}
字段名

字段类型

中文含义

特殊说明


total

float

计算折扣后订单总价

扣除所有折扣优惠后的价格，即需要支付的价格


list_total

float

折扣前订单总价

list_total = total + fullcut_total + discount_total


fullcut_total

float

满减优惠总额




discount_total

float

折扣优惠总额




gift_items

json

该订单中赠送商品信息




product_id

int

产品id

赠送产品的id


product_quantity

int

产品数量

赠送产品的个数


product_name

String

产品名称

赠送产品的名称


policy_names

String

买赠政策名称

如多个政策赠送同一个产品，该处为多个政策名称拼接而成


product_attr

json

产品口味信息




policy_icon

String

政策icon




fullcut_items

json

该订单中满减优惠信息




policy_name

String

满减政策的名称




policy_cut

float

满减金额




policy_id

int

满减政策id




discount_items

json

折扣优惠信息




policy_name

String

政策名称




policy_id

int

政策id




policy_icon

String

政策icon




discount_amount

float

本折扣优惠金额








4.7 购物车修改价格接口
请求URL
{base_url}/app_api/website_sale/edit_prices

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
"params": {
"partner_id":"0.5.0"//app版本号
        "current_products": [//需要确认订单的产品，不需改价的产品也要放入
            {
                "product_id": 15, //产品id，需改价的产品
                "product_unit_price": 30//产品单价，需要改价的产品才需要
                "product_uom":8045//产品单位id
            },
            {
                "product_id": 17, //产品id,不需改价的订单产品
                "product_uom":8045//产品单位id
            }
        ]
    },
    "method": "call",
    "id": 358244745
}

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 358244745,
    "result": {
        "msg": "产品单价已被更新",
        "data": {
            "price_total": 180.0
        },
        "title": "修改单价成功"
    }
}
失败：
Odoo系统错误

4.8 购物车客户信息
请求URL
{base_url}/app_api/user/shopchart_message
search_shopchart_message
请求方式
POST
维护者
毛涛

RequestJson
{
  "jsonrpc": "2.0",
  "method": "call",
  "params": {
   "app_version":"0.5.0",//app版本号
"method":"search_shopchart_message", //调用的函数
  }
}

ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "records": [
            {
                "addresses": [
                    {
                        "city": 0,
                        "country_name": "中国",
                        "state_name": "",
                        "zip": "",
                        "price_float":"1",
                        "phone": "",
                        "type": "contact",
                        "is_default": true,
                        "country_id": 49,
                        "id": 3,
                        "county": 0,
                        "mobile": "",
                        "street": "",
                        "city_name": "",
                        "county_name": "",
                        "active": true,
                        "state_id": 0,
                        "email": "admin@yourcompany.example.com",
                        "name": "Administrator",
                        "contact_name": "王先生",
                    }
                ],
                "mobile": "",
                "phone": "",
                "id": 1,
                "customer_name": "Administrator"
            }
        ]
    }
}




4.9 购物车更新partner_id的信息
请求URL
{base_url}/app_api/website_sale/update_cart_partnerid
update_cart_partnerid
请求方式
POST
维护者
毛涛

RequestJson
{
  "jsonrpc": "2.0",
  "method": "call",
  "params": {
"method":"update_cart_partnerid", //调用的函数
"partner_id": 1  //新的partner_id=1
"app_version":"0.5.0"//app版本号
  }
}

ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "msg": "update succeed"  //如果传partner_id则提示更新成功
    }
}


配置管理相关
5.1 获取banner和促销列表接口
请求URL
{base_url}/app_api/user/banner
user_banner_list
请求方式
POST
维护者
刘成德
说明：
1、	目前没有区分不同的经销商，如果区分，后台逻辑需要修改，APP无需修改
2、	应用的的code，目前IOS和Android是一样的，后台支持分开
3、	返回值中：Active_type 的说明

'url'：'URL'
'category'：'商品目录ID
'product'：'产品ID',
'keyword'：'关键字',
'static','静态'，无需跳转。
‘promotion’,’促销’ 跳转到促销列表
'high_profit','高利润'，跳转到高利润列表。

如果active_value的值是空，也按照无需跳转来处理
RequestJson
{
    "jsonrpc": "2.0",
"params": {
"app_version":"0.5.0",//app版本号
"method":"user_banner_list", //调用的函数
       “offset”:0,//分页的偏移量
       “limit”:10,//获取条数 如果是0，就是全部
       "code":"hollywant_app"// 应用的的code，目前IOS和Android是一样的，后台支持分开
“position”:”banner”   //用来区分显示的位置，目前支持三个值，banner：首页顶部, notice：公告消息 ,  promotion:促销列表，由于消息列表包括 notice和promotion，所以如果要获取消息列表传information，会把设置了需要显示的全部返回，无论是否有效  .如果不传，默认是banner
按照原型：获取banner，传入banner
          获取促销消息：传入promotion
          获取消息列表（公告和促销）：传入 information。
          目前没有单独获取 公告的业务场景。

 },


}


ResponseJson
成功：
{
  "jsonrpc": "2.0",
  "id": "",
  "result": {
    "msg": "banner list",
    "records": [
      {
"create_date": "2016-01-18 07:17:10",
        "active_value": "",   //和active_type 配合使用，具体的值
        "image_small": /"http://10.128.231.240:8069/web/binary/image?model=mobile.banner&id=1&field=image",//图片的URL
        "name": "优惠大促销",
        "active_type": "static"//具体的动作类别，详情见说明
      },
      {
        "active_value": "www.bandu.com",
        "image_small": "http://10.128.231.240:8069/web/binary/image?model=mobile.banner&id=2&field=image",
        "name": "qq糖大促销",
        "active_type": "url"
      }
    ]
  }
}说明：目前没有区分不同的经销商，如果区分，后台逻辑需要修改


5.2 获取品牌接口
请求URL
{base_url}/app_api/user/brand
user_brand_list
请求方式
POST
维护者
刘成德
说明：

RequestJson
{
    "jsonrpc": "2.0",
"params": {
"app_version":"0.5.0",//app版本号
"method":"user_brand_list" //调用的函数
       },


}


ResponseJson
成功：
{
  "jsonrpc": "2.0",
  "id": "",
  "result": {
    "msg": "brand list",
    "records": [
      {
        "comment": "旺旺公司之业务可追溯至台湾宜兰食品工业股份有限公司。旺旺公司于1992年正式投资大陆市场，是台湾第一个在大陆注册商标并且拥有最多注册商标的公司，于1994年在湖南设立第一家工厂，1996年在新加坡上市",
        "brand_id": 1,         //品牌ID
        "image_small": "http://localhost:8069/web/binary/image?model=brand.brand&id=1&field=image",    //图片
        "name": "旺旺"   // 品牌名
      },
      {
        "comment": "公司名称：统一企业公司\n外文名称：PRESIDENT\n总部地点：台南市永康区中正路301号\n成立时间：1967年7月1日\n经营范围：食品工业\n公司性质：上市股份制\n公司口号：飞向健康快乐的21世纪\n年营业额：三百三十五亿四千一百万元台币(07年)\n员工数：5002人(07年)\n总 裁：林苍生\n产 品：产品主要有饮料和方便面。",
        "brand_id": 2,
        "image_small": "http://localhost:8069/web/binary/image?model=brand.brand&id=2&field=image",
        "name": "统一"
      }
    ]
  }
}


Jpush推送内部接口说明
6.1 Jpush参数后台配置





维护者
刘成德
说明：



统一配置模块说明：
1、	关键配置 键和值。
访问方法：
hollywant_jpush_key=request.env['sys.config'].get_value('hollywant_jpush_key')
其中：'hollywant_jpush_key 是配置的键名






6.1 Jpush调用接口说明
方法
send_jpush_mesage(self,content,title=None,tags=None,tags_and=None,extras=None)



维护者
刘成德
说明：
所在的类 jpush_message
调用方法和参数说明
hollywant_jpush_key=request.env['sys.config'].get_value('hollywant_jpush_key')  #获取Jpush 授权值
        hollywant_jpush_url=request.env['sys.config'].get_value('hollywant_jpush_url')# 获取Jpush URL
        jpush_message1=jpush_message(hollywant_jpush_url,hollywant_jpush_key) #实例化类
        return jpush_message1.send_jpush_mesage('测试3',title='测试3',tags="123",extras={"orderid":"123"} )
参数说明
Content  ：消息体 （必填）
Title ：消息的标题
Tags ：数据类型：数组，所要发送的对象，如果是广播所有，可以不填，tag之间是或，取并集。
Tags_and:数据类型是 数组  tag 直接是 并，取交集
Extras：数据类型是 字典 选填 额外的信息：可以根据业务自己定义，例如：”ordered”:”123”


6.2 订单状态改变Jpush消息说明
方法
send_jpush_mesage(self,content,title=None,tags=None,tags_and=None,extras=None)



维护者
刘成德
说明：
所在的类 jpush_message
调用方法和参数说明
{
    'platform': 'all',
    'audience': {
        'tag': [
            'p43'
        ]
    },
    'notification': {
        'android': {
            'title': '订单取消',
            'extras': {
                'orderid': 10
            },
            'alert': '您的订单（10）被取消'
        },
        'ios': {
            'sound': 'default',
            'title': '订单取消',
            'extras': {
                'orderid': 10
            },
            'alert': '您的订单（10）被取消'
        }
    }
}
参数说明
Content  ：消息体 （必填）
Title ：消息的标题
Tags ：数据类型：数组，所要发送的对象，如果是广播所有，可以不填，tag之间是或，取并集。
Tags_and:数据类型是 数组  tag 直接是 并，取交集
Extras：数据类型是 字典 选填 额外的信息：可以根据业务自己定义，例如：”ordered”:”123”
6.3 促销类Jpush消息说明
方法
send_jpush_mesage(self,content,title=None,tags=None,tags_and=None,extras=None)



维护者
刘成德
说明：
所在的类 jpush_message
action_type 的说明

'url'：'URL'
'category'：'商品目录ID
'product'：'产品ID',
'keyword'：'关键字',
'static','静态'，无需跳转。
如果active_value的值是空，也按照无需跳转来处理
调用方法和参数说明
{
    'platform': 'all',
    'audience': ‘all’,
    'notification': {
        'android': {
            'title': 促销消息',
            'extras': {"action_type":’url’,
"action_value":’www.baidu.com’}  ,
            'alert': '旺仔牛奶促销'
        },
        'ios': {
            'sound': 'default',
            'title': '订单取消',
            'extras': {
                'orderid': 10
            },
            'alert': '您的订单（10）被取消'
        }
    }
}
参数说明
Content  ：消息体 （必填）
Title ：消息的标题
Tags ：数据类型：数组，所要发送的对象，如果是广播所有，可以不填，tag之间是或，取并集。
Tags_and:数据类型是 数组  tag 直接是 并，取交集
Extras：数据类型是 字典 选填 额外的信息：可以根据业务自己定义，例如：”ordered”:”123”


退货单相关接口
注意：退货单产品种类上限：30
7.1 创建退货单接口（已废弃，由指定客户接口自动创建）
请求URL
{base_url}/app_api/website_sale/create_return_order

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
        "vals": null

    },
    "method": "call",
    "id": 249103502
}

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 249103502,
    "result": {
        "msg": "创建退货单成功",
        "data": {
            "return_order_id": 16//退货单id
        },
        "title": "创建退货单成功"
    }
}
失败：
Odoo系统错误


7.2 退货单列表接口
请求URL
{base_url}/app_api/website_sale/return_order_list

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
        "state": [//订单状态，非必需，不查时为空即可
            "draft", //草稿
            "confirm"//确认
        ],
        "order_key":"sent_date", //排序字段，使用哪个字段排序，现设计图有两个，日期：sent_date，金额：amount_total
        "order":"asc"//顺序，asc：升序，desc：降序
        "keyword": "Delta",//搜索关键词，业代搜索范围为退货单号，手机号，客户名，收货人，属于业代当前经销商的订单，客户搜索范围为订单号，属于自己的订单，不用则不填
         "mine":True,//全部/我的区分字段，True表示显示我的数据，False表示显示全公司数据，默认值为True
    },
    "method": "call",
    "id": 321592740
}

退货单拥有6种状态：
draft    草稿状态
sent     客户确认后状态
confirm  经销商确认后状态
rejected 经销商驳回后状态
cancel   客户取消后状态
done     退货完成状态

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 321592740,
    "result": {
        "records": [//退货单列表
            {
                "name": "RO008", //退货单名
                "state": "draft", //退货单状态
                "customer_address": {//客户地址，格式同接口1.4.1返回格式
                    …………….
                },
                "customer_mobile": "", //用户手机
                "sent_date": "",  //客户确认日期
                "confirm_date": "",  //经销商确认日期
                "customer_name": "Delta PC"//用户名
            }
        ]
    }
}
失败：
Odoo系统错误

请求URL
{base_url}/app_api/website_sale/return_order_list

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
        "state": [//订单状态，非必需，不查时为空即可
            "draft", //草稿
            "confirm"//确认
        ],
        "customer_id": null, //客户id，即partner_id，与keyword不可同时存在，同时存在优先keyword
        "keyword": "Delta"//搜索关键词，搜索范围为退货单号，手机号，客户名，收货人，与customer_id不可同时存在，同时存在本字段优先
    },
    "method": "call",
    "id": 321592740
}

退货单拥有6种状态：
draft    草稿状态
sent     客户确认后状态
confirm  经销商确认后状态
rejected 经销商驳回后状态
cancel   客户取消后状态
done     退货完成状态

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 321592740,
    "result": {
        "records": [//退货单列表
            {
                "name": "RO008", //退货单名
                "state": "draft", //退货单状态
                "customer_address": {//客户地址，格式同接口1.4.1返回格式
                    …………….
                },
                "customer_mobile": "", //用户手机
                "sent_date": "",  //客户确认日期
                "confirm_date": "",  //经销商确认日期
                "customer_name": "Delta PC"//用户名
            }
        ]
    }
}
失败：
Odoo系统错误

请求URL
{base_url}/app_api/website_sale/return_order_list

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
        "state": [//订单状态，非必需，不查时为空即可
            "draft", //草稿
            "confirm"//确认
        ],
        "customer_id": null, //客户id，即partner_id，与keyword不可同时存在，同时存在优先keyword
        "keyword": "Delta"//搜索关键词，搜索范围为退货单号，手机号，客户名，收货人，与customer_id不可同时存在，同时存在本字段优先
    },
    "method": "call",
    "id": 321592740
}

退货单拥有6种状态：
draft    草稿状态
sent     客户确认后状态
confirm  经销商确认后状态
rejected 经销商驳回后状态
cancel   客户取消后状态
done     退货完成状态

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 321592740,
    "result": {
        "records": [//退货单列表
            {
                "name": "RO008", //退货单名
                "state": "draft", //退货单状态
                "customer_address": {//客户地址，格式同接口1.4.1返回格式
                    …………….
                },
                "customer_mobile": "", //用户手机
                "sent_date": "",  //客户确认日期
                "confirm_date": "",  //经销商确认日期
                "customer_name": "Delta PC"//用户名
            }
        ]
    }
}
失败：
Odoo系统错误


7.3 退货单详情接口
请求URL
{base_url}/app_api/website_sale/return_order_details

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
        "return_order_id": 13//退货单id,
“app_version”:”0.1.0”
    },
    "method": "call",
    "id": 693328142
}

ResponseJson
成功：退货单产品格式同步购物车详情格式
{
    "jsonrpc": "2.0",
    "id": 86895741,
    "result": {
        "msg": "获取退货单详情成功",
        "return_order_details": {//退货单详情
            "shipping_address": {//地址，详情见接口1.4.1
                "city": 0,
                "country_name": "",
                "display_name": "",
                "name": "",
                "zip": "",
                "mobile": "",
                "country_id": 0,
                "county": 0,
                "is_default": false,
                "phone": "",
                "street": "",
                "city_name": "",
                "county_name": "",
                "active": false,
                "state_id": 0,
                "type": "",
                "id": 0,
                "state_name": "",
                "contact_name": "联系人隔壁老王"
            },
            "return_order_products": [//退货单产品，格式见购物车详情接口，会同步更新

            ],
            "state": "draft", //退货单状态
            "return_order_name": "RO004",  //退货单号
                “company_id”:1,//经销商的公司ID
"supplier_name":”圆圆月饼公司”,//经销商名
 "supplier_phone":”18601611267”,//经销商电话
            "sent_date": "",  //客户确认日期
            "confirm_date": "",  //经销商确认日期
            "customer_name": "新用户", //客户名称
            "id": 2, //退货单id
            "amount_total": 3605000.0 //退货单总额
            "return_order_qty": 1999,//退货单产品总数
        },
        "title": "获取退货单详情成功"
    }
}
失败：
Odoo系统错误


7.4 退货单确认接口
请求URL
{base_url}/app_api/website_sale/confirm_return_order

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
        "partner_shipping_id": 9, //用户地址id
        "return_order_id": 13,//退货单id
        "return_remarks": "退明天的货"，
    },
    "method": "call",
    "id": 266476765
}

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 266476765,
    "result": {
        "msg": "确认退货单成功",
        "data": {
            "return_order_id": 13//退货单id
            "return_order_name": “RO00012” //退货单名称
        },
        "title": "确认退货单成功"
    }
}失败：
Odoo系统错误


7.5 退货单取消接口
请求URL
{base_url}/app_api/website_sale/cancel_return_order

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
        "return_order_id": 13//退货单id
    },
    "method": "call",
    "id": 938393765
}

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 938393765,
    "result": {
        "msg": "取消退货单成功",
        "data": {
            "return_order_id": 13//退货单id
        },
        "title": "取消退货单成功"
    }
}
失败：
Odoo系统错误


7.6 退货单删除接口
请求URL
{base_url}/app_api/website_sale/delete_return_order

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
        "return_order_id": 12//退货单id
    },
    "method": "call",
    "id": 938393765
}

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 697034901,
    "result": {
        "msg": "删除退货单成功",
        "data": {
            "return_order_id": 12//退货单id
        },
        "title": "删除退货单成功"
    }
}
失败：
Odoo系统错误


7.6 退货单更新接口
请求URL
{base_url}/app_api/website_sale/update_return_order

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
        "args": [
            {
                "product_id": 10, //产品id
                "add_qty": 3//需要增加的产品数量，与set_qty不可同时设置，可不设置，默认值None
                "set_qty": 3//需要设定的产品数量，与add_qty不可同时设置，如被同时设置，优先set_qty，可不设置，默认值None
                "product_unit_price":10//设定产品单位售价，不需使用时，不传即可
                "product_uom":8045//产品单位id
            }
        ],
        "return_order_id": 14
    },
    "method": "call",
    "id": 808440789
}

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 808440789,
    "result": {
        "msg": "退货单已被更新",
        "data": [
            {
                "line_id": 11, //退货行
                "product_id": 10, //产品id
                "quantity": 2000//产品数目
            },
            {
                "line_id": 12,
                "product_id": 12,
                "quantity": 1000
            }
        ],
        "title": "修改退货单成功"
    }
}
失败：
Odoo系统错误
{
    "jsonrpc": "2.0",
    "id": 16804239,
    "result": {
        "title": "修改退货单错误",
        "error": "退货单已被确认",
        "error_info": "退货单确认后无法修改"
    }
}


7.7 指定退货单客户接口（包含自动创建退货单功能）
请求URL
{base_url}/app_api/website_sale/assign_ro_customer

请求方式
POST
维护者
徐锐

RequestJson
{
    "jsonrpc": "2.0",
    "params": {
        "return_order_id": 12//退货单id，如退货单未创建时指定则传空，会自动创建退货单，返回创建的id
        "partner_shipping_id": 9, //用户地址id
        "app_version":"0.5.0"//app版本号
    },
    "method": "call",
    "id": 938393765
}

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 697034901,
    "result": {
        "msg": "指定退货单客户成功",
        "data": {
            "return_order_id": 12//退货单id
        },
        "title": "指定退货单客户成功"
    }
}
失败：
Odoo系统错误

7.8 终端退货绑定经销商
请求URL
{base_url}/app_api/b2b

请求方式
POST
维护者
成德

RequestJson
{
    "jsonrpc": "2.0",
"params": {
method：”returnorder_assign_vendor”, 调用的方法
        "return_order_id": 12//退货单id，如退货单未创建时指定则传空，会自动创建退货单，返回创建的id
        "company_id": 9, /经销商公司id
        “app_version”:”0.2.3”
    },
    "method": "call",
    "id": 938393765
}

ResponseJson
成功：
{
    "jsonrpc": "2.0",
    "id": 697034901,
    "result": {
        "msg": "指定退货单客户成功",
        "data": {
            "return_order_id": 12//退货单id
        },
        "title": "指定退货单客户成功"
    }
}
失败：
Odoo系统错误


7.9 退货返回购买过的经销商的列表
请求URL
{base_url}/app_api/b2b

请求方式
POST
维护者
成德

RequestJson
{
    "jsonrpc": "2.0",
"params": {
method：” list_vendor”, 调用的方法
“app_version”:”0.2.3
        " keyword": “月月经销商”；经销商的名字
        ”
    },
    "method": "call",
    "id": 938393765
}

ResponseJson
成功：
{
  "jsonrpc": "2.0",
  "id": null,
  "result": {
    "records": [
      {
        "company_id": 1,//公司ID
        "company_name": "YourCompany" 公司名字
      }
    ]
  }
}失败：
Odoo系统错误


后台包装首页接口
8.1 销售人员统计接口

请求URL
{base_url}/app_api/dataset/salesman_report

请求方式
POST
维护者
刘成德
说明：

RequestJson
{
    "jsonrpc": "2.0",
"params": {
"timefrom":"2016-07-21 00:00:00",
              "timeto":"2016-07-21 23:59:59"

       },
}


ResponseJson
成功：{
  "jsonrpc": "2.0",
  "id": null,
  "result": [
    {
      "sales_tatal": 56954.7252,//业代的销售总额
      "invoice_total": 37355,//业代的收款总额
      "user_name": "Administrator",//业代名字
      "uid": 1//业代的ID
"head_portrait": http://localhost:8069/web/image?model=res.users&id=1&field=image&unique=20160520104651//头像
    }
  ]
}



8.2 top_selling统计接口

请求URL
{base_url}/app_api/dataset/top_selling_report

请求方式
POST
维护者
孙洋
说明：

RequestJson
{
   "jsonrpc": "2.0",
"method": "call",
   "params": {
     "order":"ps desc" // puq desc,puq asc,ps desc,ps asc,
//puq 销量 ps 销售额
   }

 }

ResponseJson
成功：{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "top_selling": [
            {
                "price": 120,
                "sold": 100,
                "product_name": "旺旺棒冰",     "qty_available": 16,
            },
            {
                "price": 110,
                "sold": 11,
                "product_name": "[xc xc] vx",
     "qty_available": 16,
            }
        ]
    }
}



8.3 top_selling统计接口（自动售货机）

请求URL
{base_url}/app_api/dataset/top_selling_report_vmc

请求方式
POST
维护者
孙洋
说明：

RequestJson
{
   "jsonrpc": "2.0",
"method": "call",
   "params": {
     "order":"ps desc" // puq desc,puq asc,ps desc,ps asc,
//puq 销量 ps 销售额
   }

 }

ResponseJson
成功：{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "top_selling": [
            {
                "price": 120,
                "sold": 100,
                "product_name": "旺旺棒冰",     "qty_available": 16,
            },
            {
                "price": 110,
                "sold": 11,
                "product_name": "[xc xc] vx",
     "qty_available": 16,
            }
        ]
    }
}



8.4 自动售货机统计接口

请求URL
{base_url}/app_api/dataset/report_vmc

请求方式
POST
维护者
孙洋
说明：

RequestJson
{
   "jsonrpc": "2.0",
"method": "call",
   "params": {
     "order":"ps desc" // puq desc,puq asc,ps desc,ps asc,
//puq 销量 ps 销售额
   }

 }

ResponseJson
成功：{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "top_selling": [
            {
                "price": 120,
                "sold": 100,
                "warehouse_name ": "VMC1",
            },
            {
                "price": 110,
                "sold": 11,
                "warehouse_name": " VMC2",
            }
        ]
    }
}



8.5 销售收款统计接口
请求URL
{base_url}/app_api/website_sale/sale_payment_report
sale_payment_report
请求方式
GET
维护者
张蔚文
说明：

RequestParam
time_interval: "day"  // 时间间隔，可选值：month, day, week
"params": {
"app_version":"0.5.0",//app版本号
"method":"sale_payment_report" //调用的函数
}

ResponseJson
[
    {
        "date": "一月 2016",
        "sale_report_product_uom_qty": 17,        // 销售数量
        "sale_report_price_subtotal": 30017.31426,  // 销售价格
        "payment_report_price_total": 7584,       // 收款价格
    },
    {
        "date": "五月 2016",
        "sale_report_product_uom_qty": 92,
        "sale_report_price_subtotal": 25200.2007,
        "payment_report_price_total": 13031.9,
    },
    {
        "date": "四月 2016",
        "sale_report_product_uom_qty": 36,
        "sale_report_price_subtotal": 19005.8706,
        "payment_report_price_total": 34570.75,
    }
]



8.6 销售收款统计接口（自动售货机）
请求URL
{base_url}/app_api/website_sale/sale_report_vmc
sale_report
请求方式
GET
维护者
张蔚文
说明：

RequestParam
time_interval: "day"  // 时间间隔，可选值：month, day, week
warehouse_id: 0    // 售货机ID，0表示所有售货机
pay_method: "cash"  // 支付方式，可选值：cash, bank, alipay, wechat
                    // 空值表示所有支付方式
"params": {
"app_version":"0.5.0",//app版本号
"method":"sale_report" //调用的函数
}

ResponseJson
[
    {
        "date": "一月 2016",
        "sale_report_product_uom_qty": 17,        // 销售数量
        "sale_report_price_subtotal": 30017.31426,  // 销售价格
        "payment_report_price_total": 7584,       // 收款价格
    },
    {
        "date": "五月 2016",
        "sale_report_product_uom_qty": 92,
        "sale_report_price_subtotal": 25200.2007,
        "payment_report_price_total": 13031.9,
    },
    {
        "date": "四月 2016",
        "sale_report_product_uom_qty": 36,
        "sale_report_price_subtotal": 19005.8706,
        "payment_report_price_total": 34570.75,
    }
]



boss_app 接口
9.01 boss_app 订单统计接口
请求URL
{base_url}/app_api/weixin/today_order/list

请求方式
POST

维护者
毛涛
RequestJson
{
"params":{
        "timefrom":"2016-07-21 00:00:00",
        "timeto":"2016-07-21 23:59:59"
    }

}

ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "records": [
            {
                "product_sale_total": "25501.50", //订单总金额
                "product_sale_count": 7 //订单总数
            }
        ]
    }
}

9.02  boss_app 订单待付款接口
请求URL
{base_url}/app_api/weixin/un_payment/list

请求方式
POST

维护者
毛涛
RequestJson
{
"params":{
        "timefrom":"2016-07-21 00:00:00",
        "timeto":"2016-07-21 23:59:59",
        “limit”：10 //可以不传，默认5个
    }

}

ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "records": [
            {
                "partner_records": [
                    {
                        "price_total": "1175.00",  //其待付款金额
                        "product_name": "Agrolait" //待付款订单产品
                    },
                    {
                        "price_total": "4610.00",
                        "product_name": "Camptocamp"
                    }
                ],
                "product_price_total": "5785.00", //待付款总额
                "product_unpayment_acount": 6  //待付款个数
            }
        ]
    }
}

9.03  boss_app 商品排行详情接口
请求URL
{base_url}/app_api/weixin/product_ranking1

请求方式
POST

维护者
毛涛
RequestJson
{
"params":{
        "timefrom":"2016-07-21 00:00:00",
        "timeto":"2016-07-21 23:59:59",
         "company":"self"
    }
}

//boss版销售排行分我的销售排行和猴利旺的排行；当传入company的时候就显示当前公司的”我的销售”排行，如果没有company的参数时候就显示猴利旺整个的销售排行；返回的结果的格式和形式是一样的

ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "records": [
            {
                "product_specification": "",  //产品规格
                "product_uom_qty": 2,   //数量
"product_quant": 10, //剩余库存数量
"product_price_total": 14750, //金额
                "product_name": "Laptop Customized", //商品名称
                "product_uom_name": "Unit(s)"  //单位
            },

        ]
    }
}


9.04 boss_app销售订单统计接口
请求URL
{base_url}/app_api/website_sale/sale_order_report?time_interval=day
sale_order_report
请求方式
GET
维护者
孙洋
说明：

RequestParam
time_interval: "day"  // 时间间隔，可选值：month, day, week
"params": {
"app_version":"0.5.0",//app版本号
"method":"sale_order_report" //调用的函数
}

ResponseJson

[
    {
        "date": "2016-07-14",  //日期
        "amount_total": 24905.0, //订单总额
        "order_count": 27 //订单个数
    },

    {
        "date": "2016-07-20",
        "amount_total": 72903.0,
        "order_count": 38
    }
]



9.05 boss_app库存统计接口
请求URL
{base_url}/app_api/website_product/product_stock_report?limit=30
product_stock_report
请求方式
GET
维护者
孙洋
说明：

RequestParam
limit: 20  // 显示的商品个数，可选，默认20条
"params": {
"app_version":"0.5.0",//app版本号
"method":"product_stock_report" //调用的函数
}

ResponseJson
{
    "total_inventory_value": "2465763.00", //库存总价值
    "total_inventory_qty": 20594.0,  //库存总箱数
    "total_inventory_sku": 25,  //库存sku总个数
    "products": [  //正序
        {
            "product_id": 140,  //商品id
            "product_uom": "\u4ef6", //单位
            "product_name": "[123] \u6279\u6b21\u4ea7\u54c1\u6d4b\u8bd5", //名字
            "product_specificaiton": "123", //规格
            "product_qty": 17566.0, //库存数量
            "product_inventory_value": "0.00" //库存价值
             "product_sale_amount": "0.00", //销售数量
        },
        {
            "product_id": 6,
            "product_uom": "\u4ef6",
            "product_name": "[A2323] iPad Retina \u663e\u793a\u5668 (16 GB, \u767d, 2.4 GHz, 10g, 10)",
            "product_specificaiton": "",
            "product_qty": 1019.0,
            "product_inventory_value": "509500.00"
"product_sale_amount": "0.00", //销售数量
        }]

    "products_asc": [ //倒序后20
        {
            "product_id": 140,  //商品id
            "product_uom": "\u4ef6", //单位
            "product_name": "[123] \u6279\u6b21\u4ea7\u54c1\u6d4b\u8bd5", //名字
            "product_specificaiton": "123", //规格
            "product_qty": 17566.0, //库存数量
            "product_inventory_value": "0.00" //库存价值
             "product_sale_amount": "0.00", //销售数量
        },
        {
            "product_id": 6,
            "product_uom": "\u4ef6",
            "product_name": "[A2323] iPad Retina \u663e\u793a\u5668 (16 GB, \u767d, 2.4 GHz, 10g, 10)",
            "product_specificaiton": "",
            "product_qty": 1019.0,
            "product_inventory_value": "509500.00"
"product_sale_amount": "0.00", //销售数量
        }]

}




9.06  boss_app 业务员排行接口

请求URL
{base_url}/app_api/weixin/salesman_report

请求方式
POST

维护者
毛涛
RequestJson
{
"params":{
        "timefrom":"2016-07-21 00:00:00",
        "timeto":"2016-07-21 23:59:59"
    }

}

ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": [
        {
            "sales_tatal": 24968.4659, //订单总额
            "saleman_orders": 4,  //订单个数
            "user_name": "Administrator" //销售用户
        }
    ]
}

9.07  boss_app 终端销量接口
请求URL
{base_url}/app_api/weixin/terminal_report

请求方式
POST

维护者
毛涛
RequestJson
{
"params":{
        "timefrom":"2016-07-21 00:00:00",
        "timeto":"2016-07-21 23:59:59"
    }

}

ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": [
        {
            "partner_name": "Agrolait, Michel Fletcher", //终端名称
            " partner _amount_total": "320.00", //终端销售额
            " partner _order_count": 1  //终端销售量
        },
        {
            "partner_name": "Agrolait, Thomas Passot",
            " partner _amount_total": "16.50",
            " partner _order_count": 1
        }
    ]
}

售货机 接口
10.1 售货机及产品信息接口

请求URL
{base_url}/vmc/warehouse/getWarehouseProductsInfo

请求方式
POST
维护者

说明：

RequestJson
{
    "jsonrpc": "2.0",
"params": {

       },
}


ResponseJson
成功：{
  "jsonrpc": "2.0",
  "id": null,
  "result": [
    {
      "stock_warehouse_id": 56,   //售货机/仓库id
      "stock_locations": [  //货道list
        {
          "products": {  //产品详情
            "product_name": "apple",  //产品名称
            "product_price": "2.00",  //单价
            "image_small":  "http://localhost:8069/web/binary/image?model=product.template&id=3&field=image_medium&updatetime=1466447911",   //图片
            "product_id": 3,   //product_product id
            "product_qty": 8000  //库存
          },
          "stock_location_id": 186,   //货道id
          "stock_location_posx": 10086,  //货道编号
          "stock_location_name": "货道1" //货道名称
        },
        {
          "products": {},
          "stock_location_id": 184,
          "stock_location_posx": 0,
          "stock_location_name": "出货"
        },
        {
          "products": {
            "product_name": "apple",
            "product_price": "2.00",
            "image_small": "http://localhost:8069/web/binary/image?model=product.template&id=3&field=image_medium&updatetime=1466447911",
            "product_id": 3,
            "product_qty": 2000
          },
          "stock_location_id": 181,
          "stock_location_posx": 0,
          "stock_location_name": "库存"
        },
        {
          "products": {},
          "stock_location_id": 187,
          "stock_location_posx": 0,
          "stock_location_name": "货道2"
        }
      ],
      "stock_warehouse_name": "售货机"
    }
  ]
}

APP版本更新接口


请求URL
{base_url}/app_api/update_version_api
update_version
请求方式
POST
维护者
黄应飞
说明：
RequestJson
{
"jsonrpc":"2.0",
"method":"call ",
"params":{
"app_version":"0.5.0",//app版本号
"method":" update_version ", //调用的函数
 "channel": "",
"model": "mi",
"system": "android",
"appkey": "b2b",
"version": “0.1.0000"
} }

ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "jsonrpc": "2.0",
        "result": {
            "upgrade": 800,
            "version": "0.0.1111",
            "title": "更新",
            "url": "http://www.hollywant.com",
            "limitTimes": 1,
            "interval": 1,
            "changes": "bug修复",
            "size": "30M"
        }
    }
}



树莓派访问拣货发货接口


请求URL
{base_url}/app_api/pos/stock_picking

请求方式
POST
维护者
黄应飞
说明：
RequestJson
{
"jsonrpc":"2.0",
"method":"call ",
 "params":{
"username":"admin",
"password":"123456",
"order_id":"so123456",
"type":"jianhuo" //或者"fahuo"
} }

ResponseJson
{
    "jsonrpc": "2.0",
    "id": null,
    "result": {
        "jsonrpc": "2.0",
        "result": {
"user_check_info": "check_user_success"//或check_user_fail
"order_check_jianhuo_info": "no_order",//type为jianhuo 可选值
("jianhuo_success" or "already_jianhuo" or "already_fahuo")
"order_check_fahuo_info": "no_order"//type 为fahuo 可选值
("need_jianhuo " or "fahuo_success " or "already_fahuo")
        }
    }
}


         */

}
