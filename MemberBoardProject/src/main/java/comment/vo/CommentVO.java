package comment.vo;

import comment.vo.CommentVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentVO {
	private int comment_num;
	private String comment_id;
	private String comment_content;
	private String comment_date;
	private int board_num;
	private String comment_quit;
}
