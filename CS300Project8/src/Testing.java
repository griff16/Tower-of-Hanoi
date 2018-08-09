public class Testing {
	public static void main(String[] args) {
		Disk aDisk = new Disk(3);
		Disk bDisk = new Disk(2);
		Disk cDisk = new Disk(1);
		Rod rod = new Rod(5, 0);
		Rod rod2 = new Rod(9, 0);
		rod2.push(aDisk);
        rod2.push(bDisk);
        rod2.push(cDisk);
		rod.push(aDisk);
		rod.push(bDisk);
		rod.push(cDisk);
		TowerOfHanoi towerOfHanoi = new TowerOfHanoi(3, 5);
		System.out.println(towerOfHanoi.toString());
	}
}
