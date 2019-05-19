public class Main {

    static int[] coins = {2, 8, 2, 2, 2, 2, 2, 2};
    static int flag;

    public static void main(String[] args) {


        //设置第fakeNum枚是假的
        int fakeNum;

        //分成三堆
        //若前两堆一样重，假的肯定在c中
        if (sum(0, 2) == sum(3, 5)) {
            fakeNum = compare(6, 7);

            //前两堆重量不同,若第一堆重量大于第二堆
        } else if (sum(0, 2) > sum(3, 5)) {
            //丢掉每堆的最后一个币，比较前两个堆的前两个币，若相等，假币肯定在3或者6中间
            if (sum(0, 1) == sum(3, 4)) {
                fakeNum = compare(2, 5);
            } else if (sum(0, 1) > sum(3, 4)) {
                fakeNum = compare(0, 3);
                //如果第一个和第四个相等，则说明第二个和第五个当中肯定有一个是假币
                if(fakeNum == 200){
                    fakeNum = compare(1, 4);
                }
            } else {
                fakeNum = compare(1, 4);
                //如果第一个和第四个相等，则说明第二个和第五个当中肯定有一个是假币
                if(fakeNum == 200){
                    fakeNum = compare(1, 4);
                }
            }

            //若第一堆轻于第二堆
        } else {
            if (sum(0, 1) == sum(3, 4)) {
                fakeNum = compare(2, 5);
            } else if (sum(0, 1) > sum(3, 4)) {
                fakeNum = compare(1, 4);
                //如果第一个和第四个相等，则说明第二个和第五个当中肯定有一个是假币
                if(fakeNum == 200){
                    fakeNum = compare(1, 4);
                }
            } else {
                fakeNum = compare(0, 3);
                //如果第一个和第四个相等，则说明第二个和第五个当中肯定有一个是假币
                if(fakeNum == 200){
                    fakeNum = compare(1, 4);
                }
            }

        }

        if (flag == 1) {
            System.out.println("假币轻，为第" + ++fakeNum + "枚");
        } else {
            System.out.println("假币重，为第" + ++fakeNum + "枚");


        }

    }


    public static int compare(int l, int r) {
        flag = 0;

        //定义一个真币
        int realCoin = 2;


        if (coins[l] > realCoin) {
            //重
            flag = 0;
            return l;
        } else if (coins[l] < realCoin) {
            //轻
            flag = 1;
            return l;
        }

        if (coins[r] > realCoin) {
            //重
            flag = 0;
            return r;
        } else if (coins[r] < realCoin) {
            //轻
            flag = 1;
            return r;
        }


        return 200;

    }


    //求和
    public static int sum(int l, int r) {

        int sumCount = 0;

        for (int i = l; i <= r; i++) {
            sumCount += coins[i];
        }

        return sumCount;
    }


}
