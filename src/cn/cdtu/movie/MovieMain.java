package cn.cdtu.movie;

import cn.cdtu.movie.dao.*;
import cn.cdtu.movie.entity.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author: hzliu
 * @Date: 2023/12/28 22:12
 * @Description: 电影购票系统主程序
 */
public class MovieMain {

    public static final Scanner SYS_SC = new Scanner(System.in);
    /**
     * 登录客户对象
     */
    public static Customer loginUser;
    /**
     * 登录商家对象
     */
    public static Business loginBusiness;

    public static void main(String[] args) {
        showMain();
    }

    /**
     * 电影购票系统首页展示
     */
    private static void showMain() {
        while (true) {
            System.out.println("===============欢迎进入电影购票系统=================");
            System.out.println("请选择您要执行的操作：");
            System.out.println("1、用户注册");
            System.out.println("2、用户登录");
            System.out.println("3、商家入驻");
            System.out.println("4、商家登录");
            System.out.println("===============欢迎进入电影购票系统=================");
            System.out.println("请输入操作命令：");
            String command = SYS_SC.nextLine();
            switch (command) {
                case "1":
                    // 用户注册
                    customerRegister();
                    break;
                case "2":
                    // 用户登录
                    cutomerLogin();

                    break;
                case "3":
                    // 商家入驻
                    businessRegister();
                    break;
                case "4":
                    // 商家登录
                    businessLogin();
                    break;
                default:
                    System.out.println("命令有误，请确认！");
                    break;
            }
        }
    }

    /**
     * 客户注册
     */
    public static void customerRegister() {
        while (true) {
            System.out.println("请输入登录账号:");
            String loginName = SYS_SC.nextLine();
            CustomerDao customerDao = new CustomerDao();
            Customer query = customerDao.customerLogin(loginName);
            if (null != query) {
                System.out.println("该登录账号已经被注册，请重新设置");
                continue;
            }
            System.out.println("请设置登录密码:");
            String password = SYS_SC.nextLine();
            System.out.println("请输入用户姓名:");
            String userName = SYS_SC.nextLine();
            System.out.println("请输入用户性别");
            String sex = SYS_SC.nextLine();
            System.out.println("请输入用户手机号");
            String phone = SYS_SC.nextLine();
            Customer customer = new Customer();
            customer.setLoginName(loginName);
            customer.setPassword(password);
            customer.setUserName(userName);
            customer.setSex(sex);
            customer.setPhone(phone);
            //账户余额为0
            customer.setBalance(new BigDecimal(0.0));
            //创建时间即当前时间
            customer.setCreateTime(new Date());
            customer.setCreateBy(userName);
            boolean result = customerDao.insert(customer);
            if (result) {
                System.out.println("恭喜你注册成功");
                break;
            } else {
                System.out.println("注册失败");
                continue;
            }


        }


    }

    /**
     * 客户登录
     */
    public static void cutomerLogin() {
        while (true) {
            System.out.println("请你输入登录账号:");
            String loginName = SYS_SC.nextLine();
            System.out.println("请你输入登录密码:");
            String password = SYS_SC.nextLine();
            CustomerDao customerDao = new CustomerDao();
            Customer customer = customerDao.customerLogin(loginName);
            if (customer == null) {
                System.out.println("用户信息不存在");
                continue;
            }
            if (!password.equals(customer.getPassword())) {
                System.out.println("密码错误");
                continue;
            }
            System.out.println("恭喜你登录成功");
            loginUser = customer;
            showCustomerMain();
        }


    }

    /**
     * 商家注册
     */
    public static void businessRegister() {
        while (true) {
            System.out.println("请输入登录账号:");
            String loginName = SYS_SC.nextLine();
            BusinessDao businessDao = new BusinessDao();
            Business query = businessDao.businessLogin(loginName);
            if (null != query) {
                System.out.println("该登录账号已经被注册，请重新设置");
                continue;
            }
            System.out.println("请设置登录密码:");
            String password = SYS_SC.nextLine();
            System.out.println("请输入用户姓名:");
            String userName = SYS_SC.nextLine();
            System.out.println("请输入用户性别");
            String sex = SYS_SC.nextLine();
            System.out.println("请输入用户手机号");
            String phone = SYS_SC.nextLine();
            System.out.println("请输入商家名称");
            String shopName = SYS_SC.nextLine();
            System.out.println("请输入商家地址");
            String shopAdress = SYS_SC.nextLine();
            Business business = new Business();
            business.setLoginName(loginName);
            business.setPassword(password);
            business.setUserName(userName);
            business.setSex(sex);
            business.setPhone(phone);
            business.setShopName(shopName);
            business.setShopAdress(shopAdress);
            //账户余额为0
            business.setRevenue(new BigDecimal(0.0));
            //创建时间即当前时间
            business.setCreateTime(new Date());
            business.setCreateBy(userName);
            boolean result = businessDao.insert(business);
            if (result) {
                System.out.println("恭喜你注册成功");
                break;
            } else {
                System.out.println("注册失败");
                continue;
            }


        }


    }

    /**
     * 商家登录
     */
    public static void businessLogin() {
        while (true) {
            System.out.println("请你输入登录账号:");
            String loginName = SYS_SC.nextLine();
            System.out.println("请你输入登录密码:");
            String password = SYS_SC.nextLine();
            BusinessDao businessDao = new BusinessDao();
            Business business = businessDao.businessLogin(loginName);
            if (business == null) {
                System.out.println("用户信息不存在");
                continue;
            }
            if (!password.equals(business.getPassword())) {
                System.out.println("密码错误");
                continue;
            }
            System.out.println("恭喜你登录成功");
            loginBusiness = business;
            showBusinessMain();
        }


    }

    /**
     * 客户操作界面
     */
    private static void showCustomerMain() {
        while (true) {
            System.out.println("============电影购票系统客户界面===================");
            System.out.println(loginUser.getUserName() + ("男".equals(loginUser.getSex()) ? "先生" : "女士" + "欢迎您进入系统"));
            System.out.println("请您选择要操作的功能：");
            System.out.println("1、展示全部影片信息功能:");
            System.out.println("2、根据电影名称查询电影信息:");
            System.out.println("3、评分功能:");
            System.out.println("4、充值功能:");
            System.out.println("5、购票功能:");
            System.out.println("6、退出系统:");
            System.out.println("============电影购票系统客户界面===================");
            System.out.println("请输入您要操作的命令：");
            String command = SYS_SC.nextLine();
            switch (command) {
                case "1":
                    // 展示全部排片信息

                    break;
                case "2":
                    break;
                case "3":
                    // 评分功能
                    Evaluate();
                    break;
                case "4":
                    // 充值功能
                    Savabalance();
                    break;
                case "5":
                    // 购票功能
                    Order();
                    break;
                case "6":
                    // 结束方法
                    return;
                default:
                    System.out.println("不存在该命令！！");
                    break;
            }
        }
    }

    /**
     * 充值功能
     */
    public static void Savabalance() {
        CustomerDao customerDao = new CustomerDao();
        System.out.println("请输入你想充值的金额：");
        BigDecimal balance = SYS_SC.nextBigDecimal();
        BigDecimal b = new BigDecimal(0);
        int a = balance.compareTo(b);
        if (a <= 0) {
            System.out.println("这是错误的信息");
        } else {
            BigDecimal c = balance.add(loginUser.getBalance());
            boolean result = customerDao.CustomerBlance(c, loginUser.getId());
            if (result) {
                System.out.println("充值成功");
            }
        }
        showCustomerMain();
    }
   /**
    * 评价
    */
     public static void Evaluate() {
         Evaluate evaluate = new Evaluate();
         System.out.println("请输入评价电影ID号");
         long orderId = SYS_SC.nextLong();
         System.out.println("请输入你的评价分数");
         long socore = SYS_SC.nextLong();
         System.out.println("请输入你的评价");
         String remark = SYS_SC.nextLine();
         evaluate.setOrderId(orderId);
         evaluate.setId(loginUser.getId());
         evaluate.setSocore(socore);
         evaluate.setRemark(remark);
         evaluate.setCreateTime(new Date());
         evaluate.setCreateBy(loginUser.getUserName());
         EvaluateDao evaluateDao = new EvaluateDao();
         boolean result = evaluateDao.evaluate(evaluate);
         if (result) {
             System.out.println("恭喜你评价成功");

         }
     }
    /**
     * 购票
     */
    public static void Order(){

        System.out.println("请输入你想购买的电影ID");
        long movieShowId = SYS_SC.nextLong();
        System.out.println("请输入你想购买的商家名");
        String businessName = SYS_SC.next();
        BusinessDao businessDao=new BusinessDao();
//        System.out.println("请输入你想购买电影的商家ID");
//        long customerId = SYS_SC.nextLong();
        OrderDao orederDao=new OrderDao();
        OrederBusiness orederBusiness=orederDao.found(movieShowId);
        Business business = businessDao.foundrevenue(businessName);
        CustomerDao customerDao=new CustomerDao();
        BigDecimal balance=loginUser.getBalance().subtract(orederBusiness.getPrice());
        customerDao.CustomerBlance(balance,loginUser.getId());
        businessDao.businessBlance(business.getRevenue().add(orederBusiness.getPrice()),business.getId());
        System.out.println("恭喜你购票成功");
//        movieShowDao movieShowDao = new movieShowDao();
//        Order order = new Order();
//        CustomerDao customerDao = new CustomerDao();
//        MovieShow movieprice = movieShowDao.foundprice(movieShowId)
//        BigDecimal a=customerDao.customermoney(1);
//        BusinessDao businessDao = new BusinessDao();
//        Business foundrevenue = businessDao.foundrevenue();
//        BigDecimal b=foundrevenue.getRevenue().add(movieprice.getPrice());
//        order.setBalance(a);
//        order.setRevenue(b);
//        order.setId(loginUser.getId());
//        order.setMovieShowId(movieShowId);
//        order.setCustomerId(customerId);
    }
    /**
     * 商家的后台操作界面
     */
    private static void showBusinessMain(){
        while (true) {
            System.out.println("============电影购票系统商家界面===================");
            System.out.println(loginBusiness.getUserName() + ("男".equals(loginBusiness.getSex()) ? "先生" : "女士" + "欢迎您进入系统"));
            System.out.println("1、展示详情:");
            System.out.println("2、上架电影:");
            System.out.println("3、下架电影:");
            System.out.println("4、修改电影:");
            System.out.println("5、退出:");
            System.out.println("============电影购票系统商家界面===================");
            System.out.println("请输入您要操作的命令：");
            String command = SYS_SC.nextLine();
            switch (command) {
                case "1":
                    // 展示全部排片信息
                    moiveInformation();
                    break;
                case "2":
                    // 上架电影信息
                    putMoive();
                    break;
                case "3":
                    // 下架电影信息
                    deleteMoive();
                    break;
                case "4":
                    // 修改电影信息
                    break;
                case "5":
                    return;
                default:
                    System.out.println("不存在该命令！！");
                    break;
            }
        }
    }

    /**
     * 上架电影
     */
    public static void putMoive() {
        MovieShow moive = new MovieShow();
        movieShowDao movieShowDao = new movieShowDao();
        System.out.println("请输入电影ID");
        long movieId = SYS_SC.nextLong();
        System.out.println("请输入电影价格");
        BigDecimal price = SYS_SC.nextBigDecimal();
        System.out.println("请输入电影票数量");
        long number = SYS_SC.nextLong();

        moive.setBusinessId(loginBusiness.getId());
        moive.setMovieId(movieId);
        moive.setPrice(price);
        moive.setNumber(number);
        moive.setCreateBy(loginBusiness.getUserName());
        boolean result = movieShowDao.addMoive(moive);
        if (result) {
            System.out.println("上架电影成功");
        }
    }

    /**
     * 下架电影
     */
    public static void deleteMoive() {
        movieShowDao movieShowDao = new movieShowDao();
        MovieShow movieShow = new MovieShow();
        System.out.println("请输入你想要删除电影的MovieId号");
        long movieId = SYS_SC.nextLong();
        movieShow.setMovieId(movieId);
        boolean result = movieShowDao.deleteMoive(movieShow);
        if (result) {
            System.out.println("删除电影成功");
        }

    }

    /**
     * 展示详情
     */
    public static void moiveInformation() {
        MoiveDao moiveDao = new MoiveDao();
        moiveDao.Information(loginBusiness);


    }
}
//public


