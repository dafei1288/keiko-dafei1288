package net.fly78.dafei1288.chattest;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.Calendar;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class TalkProgram extends Frame implements MyValue {
	private Button b1 = null;
	private Button b2 = null;
	private Button b3 = null;
	private Button b4 = null;
	private TextField t1 = null;
	private TextField t2 = null;
	private TextField t3 = null;
	private TextArea ta1 = null;
	private Panel p1 = null;
	private Panel p2 = null;
	private Label l1 = null;
	private Label l2 = null;
	private Label l3 = null;
	private Label l4 = null;
	public DatagramSocket socket = null;// 声明datagramsocket套接字,随机绑定一个有效的端口；
	int SERVERPORT = 8080;// 默认端口为：8080
	public static String serverIP = "127.0.0.1";// 默认为本机
	public static int PORT;// 对话框输入对方的服务器的端口号
	public String port1;// 自己方服务器的端口

	public TalkProgram() {// 构造函数
		super(s3);
		/*------------------------ 初始化所有需要的部件------------------------------------*/
		t1 = new TextField("", WEIGHT1);
		t2 = new TextField("", WEIGHT3);
		t1.addKeyListener(new stringlLeft());
		t3 = new TextField("", WEIGHT2 / 2);
		ta1 = new TextArea(WEIGHT2, HEIGHT1);
		b1 = new Button(s1);
		b2 = new Button(s13);
		b2.addActionListener(new send());
		b3 = new Button(s14);
		b4 = new Button(s15);
		b4.addActionListener(new connect());
		p1 = new Panel();
		p2 = new Panel();
		l1 = new Label(s2);
		l2 = new Label(s7);
		l3 = new Label(s16);
		l4 = new Label(s17);
		p1.setLayout(new FlowLayout());
		p1.add(l1);
		p1.add(t1);
		p1.add(l4);
		p1.add(b1);
		b1.addActionListener(new SendMessage());
		p1.add(b2);
		p1.add(b3);
		b3.addActionListener(new closeConnect());
		p2.setLayout(new FlowLayout());
		p2.add(l3);
		p2.add(t3);
		p2.add(l2);
		p2.add(t2);
		p2.add(b4);

		/*------------------------------下面是关于菜单部分-------------------------------------*/

		MenuBar mb = new MenuBar();
		Menu m1 = new Menu(s4);
		Menu m2 = new Menu(s10);
		Menu m3 = new Menu(s8);
		MenuItem mi1 = new MenuItem(s5, new MenuShortcut(KeyEvent.VK_S));
		MenuItem mi2 = new MenuItem(s6, new MenuShortcut(KeyEvent.VK_O));
		MenuItem mi3 = new MenuItem(s11, new MenuShortcut(KeyEvent.VK_X));
		MenuItem mi4 = new MenuItem(s9, new MenuShortcut(KeyEvent.VK_H));
		MenuItem mi5 = new MenuItem(s12, new MenuShortcut(KeyEvent.VK_F));
		m1.add(mi1);
		m1.addSeparator();
		m1.add(mi2);
		m2.add(mi3);
		m2.addSeparator();
		m2.add(mi5);
		m3.add(mi4);
		mi1.addActionListener(new SaveMenuItem());
		mi2.addActionListener(new ReadMenuItem());
		mi3.addActionListener(new deleteContent());
		mi4.addActionListener(new showHelp());
		mb.add(m1);
		mb.add(m2);
		mb.add(m3);
		port1 = JOptionPane.showInputDialog(null, "服务器端口", "端口号：" + "",
				JOptionPane.QUESTION_MESSAGE);
		System.out.println("server port is " + port1);
		SERVERPORT = getPort(port1);
		System.out.println("server port is " + SERVERPORT);
		this.setMenuBar(mb);
		/* -------------------------组合各个部件和相互的关系---------------------------- */

		this.setLayout(new BorderLayout(5, 5));
		this.add(p2, BorderLayout.NORTH);
		this.add(ta1, BorderLayout.CENTER);
		this.add(p1, BorderLayout.SOUTH);
		this.pack();// 简单整理一下部件布局
		this.setLocation(LOCATION, LOCATION);
		this.setVisible(true);
		/*----------------------------关闭窗口------------------------------------------------*/
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		/*
		 * -------------------------------------------启动server监听端口是否有人连接-----------
		 * -----------------------------------------
		 */
		receiveMessage waitMessage = new receiveMessage();// 启动server线程监听是否有人连接
		Thread td1 = new Thread(waitMessage);
		td1.start();
		receiveFile waitFile = new receiveFile();
		Thread td2 = new Thread(waitFile);
		td2.start();
	}// 构造函数结束

	public String getIP() {
		String ip = t2.getText();
		return ip;
	}

	public int getPort(String s) {
		if (s != "") {
			int s1 = Integer.parseInt(s);
			return s1;
		} else
			return SERVERPORT;
	}

	/*-----------------------------delete chat content-----------------------------------------------------*/
	class deleteContent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			ta1.setText(null);
		}
	}

	/*--------------------------------------显示帮助文档--------------------------------------------------*/
	class showHelp implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null,
					"该作品制作人：王宁\n学号：05301052\n\n感谢大家对本产品的支持！");
		}
	}

	/* －－－－－－－－－－－－－－－－－save chat content－－－－－－－－－－－－－－－－－－－－－－－－－－－－－ */
	class SaveMenuItem implements ActionListener {// save chat message
		public void actionPerformed(ActionEvent e)// 保存信息
		{
			FileOutputStream out;
			PrintStream p; // 声明一个Print Stream流

			try {
				out = new FileOutputStream("chatlog.txt", true);
				p = new PrintStream(out);
				p.println(ta1.getText());// 方法println()，它将一个字符串发送给输出流。
				p.close();
			} catch (Exception e1) {
				System.err.println("Error writing to file");
			}

		}
	}

	/* －－－－－－－－－－－－－－－－－－－read chat content－－－－－－－－－－－－－－－－－－－－－－－－－－ */
	class ReadMenuItem implements ActionListener {// read chat message
		public void actionPerformed(ActionEvent e) {// 读取信息
			// 定义一个byte数组用于接收从文件中读出的字节,注意它的长度为1024
			byte[] buff = new byte[1024];
			int n;
			FileInputStream fis = null;
			// 生成对象infile 准备读取文件
			try {
				File f = new File("chatlog.txt");
				fis = new FileInputStream(f);
				// 从文件读取数据
				while ((n = fis.read(buff, 0, 1024)) != -1) {
					String s = new String(buff, 0, n);
					ta1.append(s);
					fis.close();
				}
			} catch (FileNotFoundException e1) {
				System.out.println("没有找到文件");
				System.exit(1);
			} catch (IOException e2) {
				System.out.println("");
			}
			// 清理
			finally {
				try {
					fis.close();
				} catch (IOException e3) {
					System.out.println("文件错误");
					System.exit(1);
				}
			}
		}
	}

	/*------------------------------------connect to server--------------------------------------------------*/
	class connect implements ActionListener {
		public void actionPerformed(ActionEvent e) {// 发送消息的实现

			try {
				serverIP = getIP();
				PORT = getPort(t3.getText());
				socket = new DatagramSocket();// 建立对象
				System.out.println("connect successfully");
			} catch (SocketException e1) {
				System.err.println("Can't open socket");
				System.exit(1);
			}
		}
	}

	/*-------－－-----------------------------client:send message --------------------------------------*/
	class SendMessage extends connect implements ActionListener {
		// 发送消息的实现

		public void actionPerformed(ActionEvent e) {
			try {
				// 构造数据报包，用来将包发送到指定主机上的指定端口号。

				System.out.println("Ip=" + serverIP);
				System.out.println("Port=" + PORT);
				DatagramPacket echo = Dgram.toDatagram(t1.getText(),
						InetAddress.getByName(serverIP), PORT);
				System.out.println("send message is used!");
				socket.send(echo);// 传送数据包
				String s = Dgram.toString(echo);
				// 时间的显示
				Calendar calendar = Calendar.getInstance();
				int hour = calendar.get(Calendar.HOUR_OF_DAY);
				int minute = calendar.get(Calendar.MINUTE);
				int second = calendar.get(Calendar.SECOND);
				ta1.append("自己:" + hour + "时" + minute + "分" + second + "秒："
						+ "\n" + s + "\n" + "\n");
				// System.err.println("Send OK");

			} catch (IOException e1) {
				System.err.println("Communication error");
				e1.printStackTrace();
			}
			t1.setText(null);
		}
	}

	/*---------------------------------------close connection------------------------------------------*/
	class closeConnect extends connect implements ActionListener// close connect

	{
		public void actionPerformed(ActionEvent e) {
			ta1.append("connect is closed");
			socket.close();
		}
	}

	/*-------－－---------------------------server:receive message ----------------------------------------*/
	class receiveMessage implements Runnable {
		private byte[] buf = new byte[1000];// 存放接受信息数组
		private DatagramPacket dp = new DatagramPacket(buf, buf.length);// 构造
																		// DatagramPacket，用来接收长度为
																		// length
																		// 的数据包。
		private DatagramSocket socket;// DatagramSocket套接字
		String date;

		public void run() {// 有机会在虚拟cpu上执行的代码
			try {
				socket = new DatagramSocket(SERVERPORT);
				System.out.println("Server started");
				while (true) {
					socket.receive(dp);// 阻塞等待连接,和client建立数据链路
					String rcvd = Dgram.toString(dp);// 将接收的包转化为字符串
					// 时间的显示
					Calendar calendar = Calendar.getInstance();
					int hour = calendar.get(Calendar.HOUR_OF_DAY);
					int minute = calendar.get(Calendar.MINUTE);
					int second = calendar.get(Calendar.SECOND);
					System.out.println("data=" + rcvd);
					ta1.append(user + ":" + hour + "时" + minute + "分" + second
							+ "秒：" + "\n" + rcvd + "\n" + "\n");
				}
			} catch (SocketException e) {// 异常处理
				System.err.println("Can't open socket");
				System.exit(1);
			} catch (IOException e) {
				System.err.println("Communication error");
				e.printStackTrace();
			}
		}
	}

	/*-------－－-----------------------------server:receive file---------------------------------------*/
	class receiveFile implements Runnable {
		// static final int INPORT1 = 8888;//端口号
		public void run() {
			try {
				ServerSocket server;
				server = new ServerSocket(SERVERPORT);
				// 创建绑定到特定端口的服务器套接字。
				Socket sock;// 创建一个Socket对象。服务器端便可以利用这个Socket对象与客户进行通讯。
				while (true) {
					sock = server.accept();// 侦听并接受到此套接字的连接
					InetAddress addr = sock.getInetAddress();// 返回套接字连接的地址。
					System.out.println(addr.getHostAddress());

					// 使用指定的基础 InputStream 创建一个 DataInputStream。
					DataInputStream infilename = new DataInputStream(sock
							.getInputStream());
					// 从流infilename中读取用 UTF-8 修改版格式编码的 Unicode 字符格式的字符串；然后以
					// String 形式返回此字符串。
					String filename = new String(infilename.readUTF());
					System.out.println("filename=" + filename);
					ta1.append("File" + filename + " is from"
							+ addr.getHostAddress() + "\n");
					File file = new File("C:" + filename);// 创建一个File实例
					// 当且仅当不存在具有此抽象路径名指定的名称的文件时，原子地创建由此抽象路径名指定的一个新的空文件。
					file.createNewFile();
					// 创建从中读取和向其中写入（可选）的随机存取文件流，该文件由 File 参数指定。
					RandomAccessFile raf = new RandomAccessFile(file, "rw");
					InputStream netIn = sock.getInputStream();// 返回此套接字的输入流。
					// BufferedInputStream(netIn),创建 BufferedInputStream
					// 并保存其参数，以便将来使用。
					DataInputStream in = new DataInputStream(
							new BufferedInputStream(netIn));
					byte[] buf = new byte[2048];
					// 从所包含的输入流中读取一定数量的字节，并将它们存储到缓冲区数组 buf 中。
					int num = in.read(buf);
					if (num != (-1))
						ta1.append("File is sending...\n");
					while (num != (-1))// 是否读完所有数据
					{
						// 将 num 个字节从指定字节数组写入到此文件，并从偏移量 0处开始。
						raf.write(buf, 0, num);// 将数据写往文件
						// 尝试跳过输入的 num 个字节以丢弃跳过的字节。
						raf.skipBytes(num);// 顺序写文件字节
						num = in.read(buf);// 继续读取文件
					}
					if (num == (-1))
						ta1.append("The file has been saved to C disk" + "\n");
					in.close();
					raf.close();
				}
			} catch (Exception e) {
				System.out.println("receive error!");
			}
		}
	}

	/*-------------------------------------compress files-----------------------------------------*/

	/*-------------------------------client:send file--------------------------------------------*/
	class sendFile implements Runnable {
		public void run() {
			JFileChooser fc = new JFileChooser();
			int return_value = fc.showOpenDialog(b2);
			if (return_value == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				try {
					PORT = getPort(t3.getText());
					serverIP = getIP();
					// 通过打开一个到实际文件的连接来创建一个 FileInputStream，该文件通过文件系统中的 File 对象
					// file 指定。
					FileInputStream fos = new FileInputStream(file);
					Socket socket = new Socket(serverIP, PORT);// 创建连接到指定服务器的套接字
					socket.setSoTimeout(20);
					DataOutputStream out = new DataOutputStream(socket
							.getOutputStream());
					out.writeUTF(file.getName());// 以与机器无关方式使用 UTF-8
													// 修改版编码将一个字符串写入基础输出流。
					ta1.append("File " + file.getName() + " begins to send!\n");
					OutputStream netOut = socket.getOutputStream();
					// BufferedOutputStream,该类实现缓冲的输出流。通过设置这种输出流，应用程序就可以将各个字节写入基础输出流中，而不必为每次字节写入调用基础系统。
					OutputStream doc = new DataOutputStream(
							new BufferedOutputStream(netOut));
					byte[] buf = new byte[2048];
					// 从此输入流中将最多 buf.length 个字节的数据读入一个字节数组中。
					int num = fos.read(buf);
					if (num != (-1))
						ta1.append("File is sending...\n");
					while (num != (-1))// 是否读完文件
					{
						doc.write(buf, 0, num);// 将指定字节数组中从偏移量0 开始的 num
												// 个字节写入基础输出流。
						doc.flush();// 清空此数据输出流。
						num = fos.read(buf);// 继续从文件中读取数据
					}
					if (num == (-1))
						ta1.append("The file sending is over.\n");
					fos.close();
					netOut.close();
					Thread.sleep(500);
				} catch (Exception ex) {
				}
			}
		}
	}

	class send implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				sendFile send = new sendFile();// 启动server线程监听是否有人连接
				Thread td = new Thread(send);
				td.start();
			} catch (Exception e1) {
				System.out.println(" sendfile thread is error!");
			}
		}
	}

	/*------------------------------------------------------------------------------------------------------*/
	class stringlLeft implements KeyListener {
		String str, str1, str2;

		public void keyReleased(KeyEvent e) {
			int n = 20 - t1.getText().length();
			if (n >= 0) {
				str = String.valueOf(n);
				l4.setText("还可输入" + str + "个字符");
				str1 = t1.getText();
				System.out.println(str1);
			} else {
				t1.setText(str1);
			}
		}

		public void keyPressed(KeyEvent e1) {

		}

		public void keyTyped(KeyEvent e) {

		}

	}

	/*------------------------------Creates a new instance of TalkProgram ---------------------------------*/

	public static void main(String args[]) {

		new TalkProgram();
	}
}
