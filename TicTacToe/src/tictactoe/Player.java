package tictactoe;

public class Player {
	private CellValue value;
	private PlayerStatus status;

	public Player(CellValue value) {
		this.value = value;
		status = PlayerStatus.Playing;
	}

	public CellValue geValue() {
		return value;
	}
	
	public PlayerStatus getStatus() {
		return status;
	}

	public void setStatus(PlayerStatus status) {
		this.status = status;
	}
}
