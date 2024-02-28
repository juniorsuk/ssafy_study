import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		List<Integer> E = new LinkedList<>();
		List<Integer> W = new LinkedList<>();
		List<Integer> S = new LinkedList<>();
		List<Integer> N = new LinkedList<>();
		List<Integer> ei = new LinkedList<>();
		List<Integer> wi = new LinkedList<>();
		List<Integer> si = new LinkedList<>();
		List<Integer> ni = new LinkedList<>();
		for (int i = 0; i<6; i++) {
			int dir = sc.nextInt();
			int dis = sc.nextInt();
			if (dir == 1) {
				E.add(dis);
				ei.add(i);
			}
			else if (dir == 2) {
				W.add(dis);
				wi.add(i);
			}
			else if (dir == 3) {
				S.add(dis);
				si.add(i);
			}
			else {
				N.add(dis);
				ni.add(i);
			}
		}
		if (E.size() == 2 && ei.get(1)-ei.get(0)!=2) {
			int i0 = E.get(0);
			int i1 = E.get(1);
			E.clear();
			E.add(i1);
			E.add(i0);
		}
		if (W.size() == 2 && wi.get(1)-wi.get(0)!=2) {
			int i0 = W.get(0);
			int i1 = W.get(1);
			W.clear();
			W.add(i1);
			W.add(i0);
		}
		if (S.size() == 2 && si.get(1)-si.get(0)!=2) {
			int i0 = S.get(0);
			int i1 = S.get(1);
			S.clear();
			S.add(i1);
			S.add(i0);
		}
		if (N.size() == 2 && ni.get(1)-ni.get(0)!=2) {
			int i0 = N.get(0);
			int i1 = N.get(1);
			N.clear();
			N.add(i1);
			N.add(i0);
		}
		int fld = 0;
		if (E.size() == 1) {
			if (N.size() == 1) fld = E.get(0)*N.get(0)-S.get(0)*W.get(1);
			else fld = E.get(0)*S.get(0)-N.get(1)*W.get(0);
		}
		else {
			if (S.size() == 1) fld = W.get(0)*S.get(0)-N.get(0)*E.get(1);
			else fld = W.get(0)*N.get(0)-S.get(1)*E.get(0);
		}
		System.out.println(k*fld);
		sc.close();
	}
}
