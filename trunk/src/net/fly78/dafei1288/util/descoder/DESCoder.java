/**  
* 概要:DES加密算法，兼容PHP的解密  
* @author cailin  
* @since v2.0  
*/  
package net.fly78.dafei1288.util.descoder;   
  
import java.io.IOException;   
import java.io.RandomAccessFile;
import java.security.SecureRandom;   
  
import javax.crypto.Cipher;   
import javax.crypto.SecretKey;   
import javax.crypto.SecretKeyFactory;   
import javax.crypto.spec.DESKeySpec;   
  
import sun.misc.BASE64Decoder;   
import sun.misc.BASE64Encoder;   
  
public class DESCoder    
{   
    private final static String KEY = "DAFEI1288"; // 字节数必须是8的倍数   
    public static byte[] desEncrypt(byte[] plainText) throws Exception   
    {   
        SecureRandom sr = new SecureRandom();   
        DESKeySpec dks = new DESKeySpec(KEY.getBytes());   
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");   
        SecretKey key = keyFactory.generateSecret(dks);   
        Cipher cipher = Cipher.getInstance("DES");   
        cipher.init(Cipher.ENCRYPT_MODE, key, sr);   
        byte data[] = plainText;   
        byte encryptedData[] = cipher.doFinal(data);   
        return encryptedData;   
    }   
       
    public static byte[] desDecrypt(byte[] encryptText) throws Exception    
    {   
        SecureRandom sr = new SecureRandom();   
        DESKeySpec dks =  new DESKeySpec(KEY.getBytes());   
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");   
        SecretKey key = keyFactory.generateSecret(dks);   
        Cipher cipher = Cipher.getInstance("DES");   
        cipher.init(Cipher.DECRYPT_MODE, key, sr);   
        byte encryptedData[] = encryptText;   
        //System.out.println(new String(encryptedData));
        byte decryptedData[] = cipher.doFinal(encryptedData);   
        return decryptedData;   
    }   
       
    public static String encrypt(String input) throws Exception   
    {   
        return base64Encode(desEncrypt(input.getBytes()));   
    }   
       
    public static String decrypt(String input) throws Exception    
    {   
        byte[] result = base64Decode(input);   
        return new String(desDecrypt(result));   
    }   
       
    public static String base64Encode(byte[] s)    
    {   
        if (s == null)   
            return null;   
        BASE64Encoder b = new sun.misc.BASE64Encoder();   
        return b.encode(s);   
    }   
       
    public static byte[] base64Decode(String s) throws IOException    
    {   
        if (s == null)   
        {   
           return null;   
        }   
        BASE64Decoder decoder = new BASE64Decoder();   
        byte[] b = decoder.decodeBuffer(s);   
        return b;   
    }   
    public static  void main(String args[]) {   
        try {   
            System.out.println(DESCoder.encrypt("汉字"));  
            String rrr = "PaperA11.htm1AddNew('[ 1 ]  机动车驾驶人违反道路交通安全法律、法规关于道路通行规定的处警告或者处____。',1)AddAnswer('20元以上200元以下罚款','Y')AddAnswer('200元以上1000元以下罚款','N')AddAnswer('500元以上2000元以下罚款','N')AddAnswer('吊销驾驶证','N')2AddNew('[ 1 ]  伪造、变造或者使用伪造、变造的机动车保险标志的，由公安机关交通管理部门予以收缴，____，并处200元以上2000元以下罚款。',1)AddAnswer('注销行驶证','N')AddAnswer('吊销驾驶证','N')AddAnswer('拘留驾驶人','N')AddAnswer('扣留该机动车','Y')3AddNew('[ 1 ]  《中华人民共和国道路交通安全法》的立法目的是加强机动车管理。',1)AddAnswer('正确','N')AddAnswer('错误','Y')4AddNew('[ 1 ]  应当报废的机动车必须及时办理注销登记。',1)AddAnswer('正确','Y')AddAnswer('错误','N')5AddNew('[ 1 ]  任何单位或者个人不得拼装机动车。',1)AddAnswer('正确','Y')AddAnswer('错误','N')6AddNew('[ 1 ]  机动车驾驶人初次申领机动车驾驶证后的____为实习期。',1)AddAnswer('3个月','N')AddAnswer('6个月','N')AddAnswer('12个月','Y')AddAnswer('24个月','N')7AddNew('[ 1 ]  汽车通过铁路道口时，最高时速不准超过____。',1)AddAnswer('50公里','N')AddAnswer('60公里','N')AddAnswer('30公里','Y')AddAnswer('40公里','N')8AddNew('[ 1 ]  机动车驶近坡道顶端等影响安全视距的路段时，应当____，并鸣喇叭示意。',1)AddAnswer('快速通过','N')AddAnswer('使用危险报警闪光灯','N')AddAnswer('减速慢行','Y')AddAnswer('随意通行','N')9AddNew('[ 1 ]  机动车在加油站____以内的路段，除使用加油设施的车辆外，不得停车。',1)AddAnswer('30米','Y')AddAnswer('20米','N')AddAnswer('10米','N')AddAnswer('5米','N')10AddNew('[ 1 ]  机动车上高速公路，____。',1)AddAnswer('可在匝道、加速车道、减速车道上超车','N')AddAnswer('不准倒车、逆行、穿越中央分隔带掉头','Y')AddAnswer('非紧急情况时可在应急车道行驶','N')AddAnswer('可以试车或学习驾驶','N')11AddNew('[ 1 ]  机动车驾驶人一个记分周期内记分达到12分的，不得驾驶机动车。',1)AddAnswer('正确','Y')AddAnswer('错误','N')12AddNew('[ 1 ]  对制动失效的被牵引车，可以用软连接装置牵引。',1)AddAnswer('正确','N')AddAnswer('错误','Y')13AddNew('[ 1 ]  机动车在高速公路上行驶，遇雾天等气象，能见度小于50米时，车速不得超过每小时20公里，并从最近的出口尽快驶离高速公路。',1)AddAnswer('正确','Y')AddAnswer('错误','N')14AddNew('[ 1 ]  机动车驾驶人交通肇事逃逸致人死亡的，处7年以上15年以下有期徒刑。',1)AddAnswer('正确','Y')AddAnswer('错误','N')15AddNew('[ 1 ]  机动车驾驶人撞伤行人，应承担交通事故民事责任。',1)AddAnswer('正确','Y')AddAnswer('错误','N')16AddNew('[ 1 ]  机动车正常行驶，意外致人重伤或死亡，驾驶人应当承担刑事责任和相应的行政责任。',1)AddAnswer('正确','N')AddAnswer('错误','Y')17AddNew('[ 1 ]  醉酒后驾驶机动车的，公安机关交通管理部门可以扣留驾驶证。',1)AddAnswer('正确','Y')AddAnswer('错误','N')18AddNew('[ 1 ]  发生交通事故后，交通警察进行调解未达成协议的，当事人可以向人民法院提起民事诉讼。',1)AddAnswer('正确','Y')AddAnswer('错误','N')19AddNew('[ 1 ]  交通事故当事人事后报警，公安交通管理部门依法未予受理的，当事人可以就交通事故处理向人民法院提起民事诉讼。',1)AddAnswer('正确','Y')AddAnswer('错误','N')20AddNew('[ 1 ]  机动车驾驶证遗失的，申请补发时应提供____和遗失的书面声明。',1)AddAnswer('单位证明','N')AddAnswer('居委会证明','N')AddAnswer('机动车驾驶人的身份证明','Y')AddAnswer('车辆证明','N')21AddNew('[ 1 ]  申领小型汽车驾驶证的人，在暂住地居住的，应当回户籍所在地进行申请。',1)AddAnswer('正确','N')AddAnswer('错误','Y')22AddNew('[ 1 ]  机动车驾驶人可以委托代理人办理驾驶证的换证、补证业务。',1)AddAnswer('正确','Y')AddAnswer('错误','N')23AddNew('[ 1 ]  初次取得的机动车驾驶证的有效期为10年。',1)AddAnswer('正确','N')AddAnswer('错误','Y')24AddNew('[ 1 ]  多次发生道路交通安全违法行为、道路交通事故，或者发生重大道路交通事故的被保险车，保险公司应当____保险费率的幅度。',1)AddAnswer('保持','N')AddAnswer('降低','N')AddAnswer('提高','Y')AddAnswer('适当调整','N')25AddNew('[ 1 ]  被保险人故意制造道路交通事故的，造成受害人的财产损失，保险公司不承担赔偿责任。',1)AddAnswer('正确','Y')AddAnswer('错误','N')26AddNew('[ 2 ]  [TJ]机动车驾驶人信息卡可以用于记载驾驶人的交通安全教育、____和发生的交通事故等信息。',1)AddAnswer('交通违法行为发生情况','N')AddAnswer('交通违法行为累计记分情况','Y')AddAnswer('交通违法行为处理情况','N')AddAnswer('交通违法行为罚款金额','N')27AddNew('[ 2 ]  [TJ]车辆在五交叉以上路口通行直对的路口或者右侧的隔一个路口的，应当按______。',1)AddAnswer('右转弯通过','N')AddAnswer('直行通过','Y')AddAnswer('左转弯通过','N')AddAnswer('随意通行','N')28AddNew('[ 2 ]  [TJ]客运出租车应当在出租车站点右侧路边顺序临时停车上下乘客。',1)AddAnswer('正确','Y')AddAnswer('错误','N')29AddNew('[ 2 ]  [TJ]机动车驾驶人初领、换领机动车驾驶证和依照规定进行机动车驾驶证审验时，应当经身体健康适应性检测合格。',1)AddAnswer('正确','Y')AddAnswer('错误','N')30AddNew('[ 2 ]  [TJ]任何人可以在交叉路口、车行道、桥梁、地道、涵洞、过街天桥等地点散发宣传品、兜售商品或者乞讨。',1)AddAnswer('正确','N')AddAnswer('错误','Y')31AddNew('[ 3 ]  交通信号灯红灯亮时，____车辆在不妨碍被放行的车辆、行人通行的情况下，可以通行。',1)AddAnswer('右转弯','Y')AddAnswer('左转弯','N')AddAnswer('Ｔ形路口的转弯','N')AddAnswer('各方行驶','N')32AddNew('[ 3 ]  道路与铁路平面交叉道口有两个红灯交替闪烁或者一个红灯亮时，____。',1)AddAnswer('车辆在确保安全的情况下可以通行','N')AddAnswer('禁止车辆、行人通行','Y')AddAnswer('禁止车辆通行，但行人可以通行','N')AddAnswer('禁止行人通行，但车辆可以通行','N')33AddNew('[ 3 ]  图中所示标志是____。',1)AddAnswer('旅游区标志','Y')AddAnswer('指示标志','N')AddAnswer('指路标志','N')AddAnswer('辅助标志','N')AddImages('22111.GIF')34AddNew('[ 3 ]  图中标志的含义是____。',1)AddAnswer('下陡坡','Y')AddAnswer('滑行','N')AddAnswer('下行','N')AddAnswer('上陡坡','N')AddImages('22115.GIF')35AddNew('[ 3 ]  图中标志的含义是____。',1)AddAnswer('限制宽度','Y')AddAnswer('限制高度','N')AddAnswer('解除限制宽度','N')AddAnswer('限制桥宽','N')AddImages('22152.GIF')36AddNew('[ 3 ]  图中标志的含义是____。',1)AddAnswer('禁止直行和向右转弯','N')AddAnswer('准许直行和向左转弯','N')AddAnswer('禁止直行和向左转弯','Y')AddAnswer('准许直行和向右转弯','N')AddImages('22158.GIF')37AddNew('[ 3 ]  图中标志的含义是表示前方300米道路封闭。',1)AddAnswer('正确','Y')AddAnswer('错误','N')AddImages('22261.gif')38AddNew('[ 3 ]  如图所示为人行横道线，是行人横穿 ____的标线。',1)AddAnswer('街道','N')AddAnswer('车行道','Y')AddAnswer('铁路道口','N')AddAnswer('高速公路','N')AddImages('2316.GIF')39AddNew('[ 3 ]  如图所示白色标线框内的区域表示禁止车辆停放位置。',1)AddAnswer('正确','N')AddAnswer('错误','Y')AddImages('2325.GIF')40AddNew('[ 3 ]  如图所示，路面上施划的导向箭头线表示车辆应该行驶的方向。',1)AddAnswer('正确','Y')AddAnswer('错误','N')AddImages('2327.GIF')41AddNew('[ 3 ]  图中所示斑马状导流线，表示车辆应按规定的路线行驶，但可以压线或越线。',1)AddAnswer('正确','N')AddAnswer('错误','Y')AddImages('23212.GIF')42AddNew('[ 3 ]  图中警察手势为____信号。',1)AddAnswer('左转弯','N')AddAnswer('左转弯辅助','N')AddAnswer('停止','N')AddAnswer('左小转弯','Y')AddImages('2414.GIF')43AddNew('[ 3 ]  图中警察手势为____信号。',1)AddAnswer('左转弯待转','Y')AddAnswer('左转弯','N')AddAnswer('左小转弯辅助','N')AddAnswer('左小转弯','N')AddImages('2415.GIF')44AddNew('[ 3 ]  图中警察手势为左转弯信号。',1)AddAnswer('正确','N')AddAnswer('错误','Y')AddImages('2422.GIF')45AddNew('[ 3 ]  图中警察手势为示意违章靠边停车信号。',1)AddAnswer('正确','Y')AddAnswer('错误','N')AddImages('24211.GIF')46AddNew('[ 4 ]  水毁路面影响行车安全，不易通行的原因是____。',1)AddAnswer('无法观察到暗坑和凸起的路面','Y')AddAnswer('路面滑溜，制动时容易侧滑','N')AddAnswer('车辆容易打滑','N')AddAnswer('日光反射阻挡视线','N')47AddNew('[ 4 ]  在泥泞路上制动时,车轮易发生侧滑或甩尾，导致交通事故。',1)AddAnswer('正确','Y')AddAnswer('错误','N')48AddNew('[ 4 ]  夜间行车时，全车灯光突然熄灭，应当紧急制动，迅速停车。',1)AddAnswer('正确','N')AddAnswer('错误','Y')49AddNew('[ 4 ]  行车中遇到后方车辆要求超车时，应____。',1)AddAnswer('及时向右行驶让行','Y')AddAnswer('减速慢行','N')AddAnswer('靠右侧加速行驶','N')AddAnswer('不让行','N')50AddNew('[ 4 ]  驾驶人清洗车辆时，错误的做法是____。',1)AddAnswer('不随便乱扔垃圾','N')AddAnswer('把垃圾整理好放入垃圾袋','N')AddAnswer('把垃圾放入允许堆放的地方','N')AddAnswer('把垃圾随便扔到道路上','Y')51AddNew('[ 4 ]  驾驶车辆在道路上行驶时，车速应当按照规定的速度安全行驶。',1)AddAnswer('正确','Y')AddAnswer('错误','N')52AddNew('[ 4 ]  在正常行车中，尽量靠近中心线或压线行驶，不给对方车辆留有侵占行驶路线的机会。',1)AddAnswer('正确','N')AddAnswer('错误','Y')53AddNew('[ 4 ]  天气炎热，驾驶人可以赤背、光脚、穿拖鞋驾驶车辆。',1)AddAnswer('正确','N')AddAnswer('错误','Y')54AddNew('[ 4 ]  驾驶人一边驾车，一边吸烟对安全行车无影响。',1)AddAnswer('正确','N')AddAnswer('错误','Y')55AddNew('[ 4 ]  驾驶车辆在交叉路口前变更车道时，应____驶入要变更的车道。',1)AddAnswer('在路口前实线区内根据需要','N')AddAnswer('进入路口实线区内','N')AddAnswer('在虚线区按导向箭头指示','Y')AddAnswer('在路口停止线前','N')56AddNew('[ 4 ]  行车中遇醉酒的行人时，应____。',1)AddAnswer('鸣喇叭警示','N')AddAnswer('迅速从一侧绕过','N')AddAnswer('减速慢行，保持足够的横向间距','Y')AddAnswer('紧随其后行驶','N')57AddNew('[ 4 ]  行车中超越同向行驶的自行车时，合理的做法是____。',1)AddAnswer('让自行车先行','N')AddAnswer('注意观察动态，减速慢行，留有足够的安全距离','Y')AddAnswer('连续鸣喇叭提醒其让路','N')AddAnswer('持续鸣喇叭并加速超越','N')58AddNew('[ 4 ]  行车中遇畜力车时，应____。',1)AddAnswer('急加速绕过','N')AddAnswer('临近时鸣喇叭','N')AddAnswer('在较远处鸣喇叭，并提前减速','Y')AddAnswer('紧随其后行驶','N')59AddNew('[ 4 ]  车辆在雾天临时停车时，应开启____、示廓灯和后位灯。',1)AddAnswer('危险报警闪光灯','Y')AddAnswer('左转向灯','N')AddAnswer('前大灯','N')AddAnswer('倒车灯','N')60AddNew('[ 4 ]  驾驶车辆汇入车流时，应提前开启转向灯，保持直线行驶，通过后视镜观察左右情况，确认安全后汇入合流。',1)AddAnswer('正确','Y')AddAnswer('错误','N')61AddNew('[ 4 ]  变更车道时，应开启转向灯，迅速驶入侧方车道。',1)AddAnswer('正确','N')AddAnswer('错误','Y')62AddNew('[ 4 ]  驾驶车辆驶近人行横道时，若遇行人正在横穿道路，尽量从行人后方绕过。',1)AddAnswer('正确','N')AddAnswer('错误','Y')63AddNew('[ 4 ]  车辆在交叉路口绿灯亮后，遇非机动车抢道行驶时，可以不让行。',1)AddAnswer('正确','N')AddAnswer('错误','Y')64AddNew('[ 4 ]  行车中遇牲畜通过道路影响通行时，可采取连续鸣喇叭的方式进行驱赶。',1)AddAnswer('正确','N')AddAnswer('错误','Y')65AddNew('[ 4 ]  行车中遇故意不避让车辆的行人时，可连续鸣喇叭加速通过。',1)AddAnswer('正确','N')AddAnswer('错误','Y')66AddNew('[ 5 ]  车辆在高速公路上超车，车速为每小时100公里时，最小横向间距应为____。',1)AddAnswer('0.8米','N')AddAnswer('1.0米','N')AddAnswer('1.2米','N')AddAnswer('1.5米','Y')67AddNew('[ 5 ]  车辆行经立交桥左转弯时，应驶过桥后向右转弯进入匝道，再右转弯完成。',1)AddAnswer('正确','Y')AddAnswer('错误','N')68AddNew('[ 5 ]  夜间在窄路、窄桥与非机动车交会时应使用____。',1)AddAnswer('远光灯','N')AddAnswer('近光灯','Y')AddAnswer('危险报警闪光灯','N')AddAnswer('防雾灯','N')69AddNew('[ 5 ]  夜间驾驶人对事物的观察能力明显比白天差，视距变短。',1)AddAnswer('正确','Y')AddAnswer('错误','N')70AddNew('[ 5 ]  夜间尾随前车行驶时，后车可以使用远光灯。',1)AddAnswer('正确','N')AddAnswer('错误','Y')71AddNew('[ 5 ]  雾天行车时，因视线不良，应随时注意行人与其他车辆的动态，____。',1)AddAnswer('连续鸣喇叭','N')AddAnswer('正常速度行驶','N')AddAnswer('开启远光灯','N')AddAnswer('低速行驶','Y')72AddNew('[ 5 ]  行车中遇有浓雾或特大雾天，能见度过低行车困难时，应____。',1)AddAnswer('开启前照灯行驶','N')AddAnswer('开启示廓灯、雾灯行驶','N')AddAnswer('选择安全地点停车','Y')AddAnswer('开启危险报警闪光灯行驶','N')73AddNew('[ 5 ]  大风天气行车中，如果遇到狂风袭来，感觉车辆产生横向偏移时，要急转方向以恢复行驶方向。',1)AddAnswer('正确','N')AddAnswer('错误','Y')74AddNew('[ 5 ]  车辆在山区低等级冰雪道路遇坡道时，下坡车应当让上坡车先行。',1)AddAnswer('正确','N')AddAnswer('错误','Y')75AddNew('[ 5 ]  车辆在泥泞路行驶，发生侧滑时，要冷静清醒，在抬加速踏板的同时，向后轮侧滑的一方缓慢转动转向盘进行修正。',1)AddAnswer('正确','Y')AddAnswer('错误','N')76AddNew('[ 6 ]  驾驶人发现轮胎漏气时，应迅速制动减速，将车辆尽快驶离行车道，停放在路边安全地点。',1)AddAnswer('正确','N')AddAnswer('错误','Y')77AddNew('[ 6 ]  车辆发生爆胎后，驾驶人在尚未控制住车速前，不要冒险使用行车制动器停车，以避免车辆横甩发生更大的险情。',1)AddAnswer('正确','Y')AddAnswer('错误','N')78AddNew('[ 6 ]  驾驶人发现转向突然不灵，但还可实现转向时，应低速将车开到附近修理厂修好后再行驶。',1)AddAnswer('正确','Y')AddAnswer('错误','N')79AddNew('[ 6 ]  安装制动防抱死装置（ABS）的车辆，驾驶人发现汽车转向失效时，应轻踏制动踏板。',1)AddAnswer('正确','N')AddAnswer('错误','Y')80AddNew('[ 6 ]  制动突然失灵，避让障碍物时，要掌握'先避人，后避物'原则。',1)AddAnswer('正确','Y')AddAnswer('错误','N')81AddNew('[ 6 ]  车辆在泥泞路上发生侧滑时，应____。',1)AddAnswer('向侧滑的一侧转动转向盘适量修正','Y')AddAnswer('向侧滑的另一侧转动转向盘适量修正','N')AddAnswer('迅速制动减速','N')AddAnswer('迅速制动停车','N')82AddNew('[ 6 ]  缓慢翻车有可能跳车逃生时，应向翻车的方向跳车。',1)AddAnswer('正确','N')AddAnswer('错误','Y')83AddNew('[ 6 ]  雨天车辆在高速公路行驶发生'水滑'现象时，应____。',1)AddAnswer('急踏制动踏板减速','N')AddAnswer('迅速转动转向盘进行调整','N')AddAnswer('握稳方向，逐渐降低车速','Y')AddAnswer('提高车速增大车轮排水量','N')84AddNew('[ 6 ]  大雨天在高速公路行车，为避免发生'水滑'而造成危险，要____行驶。',1)AddAnswer('降低车速','Y')AddAnswer('提高车速','N')AddAnswer('安装防滑装置','N')AddAnswer('增加轮胎气压','N')85AddNew('[ 6 ]  车辆在高速公路意外撞击护栏的瞬间，应迅速向相反方向转向躲避。',1)AddAnswer('正确','N')AddAnswer('错误','Y')86AddNew('[ 7 ]  转向盘是操纵汽车行驶方向的装置，用以控制____实现车辆的转向。',1)AddAnswer('被动轮','N')AddAnswer('车后轮','N')AddAnswer('转向轮','Y')AddAnswer('从动轮','N')87AddNew('[ 7 ]  调节座椅头枕高度，使头枕中心____。',1)AddAnswer('抵住脖子','N')AddAnswer('与颈平齐','N')AddAnswer('与头平齐','Y')AddAnswer('抵住颈椎','N')88AddNew('[ 7 ]  汽车转向盘的最大自由转动量不得超过____。',1)AddAnswer('5度','N')AddAnswer('30度','Y')AddAnswer('10度','N')AddAnswer('20度','N')89AddNew('[ 7 ]  使用已经有裂纹或损伤的轮胎行驶，容易引起____。',1)AddAnswer('车辆跑偏','N')AddAnswer('爆胎','Y')AddAnswer('转向失控','N')AddAnswer('增大行驶阻力','N')90AddNew('[ 7 ]  为了避免爆胎，平时一定要定期检查轮胎的气压是否符合标准，外表有无损伤等，清理胎纹间杂物。',1)AddAnswer('正确','Y')AddAnswer('错误','N')91AddNew('[ 8 ]  伤员众多时，最后送往医院的是____伤员。',1)AddAnswer('颈椎受伤','Y')AddAnswer('大出血','N')AddAnswer('呼吸困难','N')AddAnswer('肠管脱出','N')92AddNew('[ 8 ]  搬运昏迷或有窒息危险的伤员时，应采用____的方式。',1)AddAnswer('俯卧','N')AddAnswer('仰卧','N')AddAnswer('侧卧','N')AddAnswer('侧俯卧','Y')93AddNew('[ 8 ]  抢救失血伤员时，应先进行____。',1)AddAnswer('观察','N')AddAnswer('包扎','N')AddAnswer('止血','Y')AddAnswer('询问','N')94AddNew('[ 8 ]  救助休克伤员时，应采取保暖措施，防止热损耗。',1)AddAnswer('正确','Y')AddAnswer('错误','N')95AddNew('[ 8 ]  伤员前臂或小腿出血，可在腋窝或肘窝加垫屈肢固定。',1)AddAnswer('正确','Y')AddAnswer('错误','N')96AddNew('[ 9 ]  [TJ]在同方向划有____以上机动车道的道路上， 城市公交车 、摩托车、拖拉机、电瓶车、轮式专用机械车、低速载货汽车、三轮汽车在最右侧车道行驶。',1)AddAnswer('一条','Y')AddAnswer('两条','N')AddAnswer('三条','N')AddAnswer('四条','N')97AddNew('[ 9 ]  年龄在60岁以上持有准驾车型为大型客车的驾驶人，应当到驾驶证核发地车辆管理所换准驾车型为小型汽车的驾驶证。',1)AddAnswer('正确','Y')AddAnswer('错误','N')98AddNew('[ 9 ]  已持有小型汽车驾驶证，申请增加中型客车准驾车型的，应当在申请前最近一个记分周期内没有满分记录。',1)AddAnswer('正确','N')AddAnswer('错误','Y')99AddNew('[ 9 ]  客车行经转弯、上下坡、凹凸路时，应让乘客学会保护自己，抓住车内固定物，尤其提醒后排乘客注意安全。',1)AddAnswer('正确','Y')AddAnswer('错误','N')100AddNew('[ 9 ]  驾驶客车在山区、桥梁、高速公路遇紧急情况避险时，应先转动转向盘避让，再使用制动减速。',1)AddAnswer('正确','N')AddAnswer('错误','Y')";
            String mm = DESCoder.encrypt(rrr);
            System.out.println(mm); 
            System.out.println(DESCoder.decrypt(mm));   
            //System.out.println("SSOFOUNDERaaaaaa".getBytes().length);
            /*
            RandomAccessFile fio = new RandomAccessFile("C:\\dbcars\\A1.cardb","r");
            StringBuffer sb = new StringBuffer();
            String t = null;
            t = fio.readLine();
            while(t!=null){
            	sb.append(t);
            	t = fio.readLine();
            }
            String res = DESCoder.encrypt(sb.toString());
            RandomAccessFile fiof = new RandomAccessFile("C:\\dbcars\\A11.cardb","rw");
            fiof.writeBytes(res);//.writeUTF(res);
            */
            //String res = DESCoder.encrypt(sb.toString());
            RandomAccessFile fiof = new RandomAccessFile("C:\\dbcars\\A1_1.cardb","rw");
            StringBuffer sb = new StringBuffer();
            String s = null;
            int i=0;//++
            String res =null;
            while((s=fiof.readLine())!=null){
            	//System.out.println(s);
            	sb.append(s);
            	res = s;
            }
            //System.out.println(new String(sb.toString().getBytes("iso8859-1"),"utf-8"));
            
            String de = new String(sb.toString().getBytes("iso8859-1"),"utf-8");
            //System.out.println(de);   
           // de = de.substring(1, de.length());
           // System.out.println(de);   
            /*
            de = de.replaceAll("\r\n", "");
            de = de.replaceAll("\n\t", "");
            de = de.replaceAll("\r", "");
            de = de.replaceAll("\n", "");
            de = de.replaceAll(System.getProperty("line.separator"), "");
            */
            //System.out.println(de.length());
            //System.out.println(de);
            res = new String(res.getBytes("iso8859-1"),"utf-8");
            System.out.println(DESCoder.encrypt(res));   
            
            ;//.writeUTF(res);
            
        } catch (Exception e) {   
            e.printStackTrace();   
        }   
    }   
}  
/*

 */

