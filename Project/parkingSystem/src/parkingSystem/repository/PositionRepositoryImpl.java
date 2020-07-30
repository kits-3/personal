package parkingSystem.repository;

public class PositionRepositoryImpl implements PositionRepository {
	public void PearlPlaza() {	
		String pos [][]= new String [11][11];
			
		for(int i=0; i<11;i++)
			{
				for(int j=0;j<11;j++)
				{
					pos[i][j] = " x ";
					pos[0][0]="    ";
					pos[0][1]=" A ";
					pos[0][2]=" B ";
					pos[0][3]=" C ";
					pos[0][4]=" D ";
					pos[0][5]=" E ";
					pos[0][6]=" E ";
					pos[0][7]=" F ";
					pos[0][8]=" G ";
					pos[0][9]=" H ";
					pos[0][10]=" I ";
					pos[1][0]="  1 ";
					pos[2][0]="  2 ";
					pos[3][0]="  3 ";
					pos[4][0]="  4 ";
					pos[5][0]="  5 ";
					pos[6][0]="  6 ";
					pos[7][0]="  7 ";
					pos[8][0]="  8 ";
					pos[9][0]="  9 ";
					pos[10][0]=" 10 ";
					System.out.print(pos[i][j]);	
				}
				System.out.print("\n");
			}
		System.out.println("\n------------Pearl Plaza Park-----------");
	}
	public void GrandPlace() {
		String pos [][]= new String [6][11];
		
		for(int i=0; i<6;i++)
			{
				for(int j=0;j<11;j++)
				{
					pos[i][j] = " x ";
					pos[0][0]="    ";
					pos[0][1]=" A ";
					pos[0][2]=" B ";
					pos[0][3]=" C ";
					pos[0][4]=" D ";
					pos[0][5]=" E ";
					pos[0][6]=" E ";
					pos[0][7]=" F ";
					pos[0][8]=" G ";
					pos[0][9]=" H ";
					pos[0][10]=" I ";
					pos[1][0]="  1 ";
					pos[2][0]="  2 ";
					pos[3][0]="  3 ";
					pos[4][0]="  4 ";
					pos[5][0]="  5 ";
					System.out.print(pos[i][j]);	
				}
				System.out.print("\n");
			}
		System.out.println("\n------------Grand Place-----------");
	}
	public void VanHanhMall() {
		String pos [][]= new String [9][11];
		
		for(int i=0; i<9;i++)
			{
				for(int j=0;j<11;j++)
				{
					pos[i][j] = " x ";
					pos[0][0]="    ";
					pos[0][1]=" A ";
					pos[0][2]=" B ";
					pos[0][3]=" C ";
					pos[0][4]=" D ";
					pos[0][5]=" E ";
					pos[0][6]=" E ";
					pos[0][7]=" F ";
					pos[0][8]=" G ";
					pos[0][9]=" H ";
					pos[0][10]=" I ";
					pos[1][0]="  1 ";
					pos[2][0]="  2 ";
					pos[3][0]="  3 ";
					pos[4][0]="  4 ";
					pos[5][0]="  5 ";
					pos[6][0]="  6 ";
					pos[7][0]="  7 ";
					pos[8][0]="  8 ";
					System.out.print(pos[i][j]);	
				}
				System.out.print("\n");
			}
		System.out.println("\n------------Van Hanh Mall-----------");
	}
}
