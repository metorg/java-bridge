package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgeBoard bridgeBoard;
    private int current;
    private int chance=1;

    public BridgeGame(){
       init();
    }

    public void init(){
        bridgeBoard = new BridgeBoard();
        current =0;
    }


    public boolean compare(List<String> bridge,String userInput){
        System.out.println(userInput);
        if(bridge.get(current).equals(convertUserInput(userInput))){
           move(userInput,"O");
           return true;
        }
        System.out.println(bridge.get(current));
        System.out.println(convertUserInput(userInput));
        move(userInput,"X");
        return false;
    }

    private String convertUserInput(String userInput){
        if(userInput.equals("U"))return "1";
        return "0";
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String input,String result) {
        bridgeBoard.addMove(input,result);
        indexMove(result);
    }

    public void indexMove(String result){
        if(result=="O"){
            current=current+1;
            return;
        }
            current=0;
    }

    public BridgeBoard showCurrentBoard(){
        return bridgeBoard;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(List<String> bridge,String command) {
        if(command=="R"){
            chance+=1;
            init();
            return false;
        }
        current=bridge.size();
        return false;
    }

    public boolean gameFinish(List<String> bridge){
        if(current==bridge.size()){
            return true;
        }
        return false;
    }

    public int getChance(){
        return chance;
    }
}
