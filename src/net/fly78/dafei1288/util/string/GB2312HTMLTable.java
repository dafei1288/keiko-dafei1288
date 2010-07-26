package net.fly78.dafei1288.util.string;

public class GB2312HTMLTable {
	public static void main(String[] args) {
		byte[] two_bytes = new byte[2];

		System.out
				.print(" <TABLE   border= '1 '     cellPadding=0   cellSpacing=0   width= '199 '   style= 'border:   1px   solid; '   bordercolor= '#ff6600 '> <tr> ");
		System.out
				.print(" <TH   bordercolordark=#ffffff   bgColor=#FEC261   height= '20 '   align= 'center '> <font   color= '#000000 '> &nbsp;&nbsp;&nbsp;&nbsp; </font> </TH> ");
		System.out
				.print(" <TH   bordercolordark=#ffffff   bgColor=#FEC261   height= '20 '   align= 'center '> <font   color= '#000000 '> 位 </font> </TH> ");

		for (int i = 1; i <= 94; i++) {
			System.out
					.print(" <TH   bordercolordark=#ffffff   bgColor=#FEC261   height= '20 '   align= 'center '> <font   color= '#000000 '> "
							+ i + " </font> </TH> ");
		}

		System.out.println(" </tr> ");
		System.out
				.println(" <tr> <td   style=border-style: 'none '> 区 </td> <td   style=border-style: 'none '> &nbsp;&nbsp;&nbsp;&nbsp; </td> <tr> ");

		for (int i = 1; i <= 94; i++) {
			for (int j = 1; j <= 94; j++) {
				if (j == 1) {
					System.out
							.print(" <tr> <td   style=border-style: 'none '> "
									+ i
									+ " </td> <td   style=border-style: 'none '> &nbsp;&nbsp;&nbsp;&nbsp; </td> <td   style=border-style: 'none '> ");
				} else
					System.out.print(" <td   style=border-style: 'none '> ");

				two_bytes[0] = (byte) (0xA0 + i);
				two_bytes[1] = (byte) (0xA0 + j);
				System.out.write(two_bytes, 0, 2);

				System.out.print(" </td> ");
			}

			System.out.println(" </tr> ");

		}
		System.out.print(" </table> ");

	}
}
