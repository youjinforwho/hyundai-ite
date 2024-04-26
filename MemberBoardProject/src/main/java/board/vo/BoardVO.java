package board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	private int board_num;
	private String board_id;
	private String board_subject;
	private String board_content;
	private String board_date;
	private String board_quit;
}
