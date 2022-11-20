package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int playerTryCount = 1;
    private int playerPosition = -1;
    private List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        playerPosition++;
    }

    public String judge(String forward) {
        move();
        if (bridge.get(playerPosition).equals(forward)) {
            return "O";
        }
        return "X";
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        playerPosition = -1;
        playerTryCount += 1;
    }

    public boolean isGameWin(String last) {
        if (bridge.size() == playerPosition + 1) {
            if (last.equals(bridge.get(bridge.size() - 1)))
                return true;
        }
        return false;
    }

    public int getPlayerTryCount() {
        return playerTryCount;
    }

    public int getPlayerPosition() {
        return playerPosition;
    }

    public List<String> getBridge() {
        return bridge;
    }
}
