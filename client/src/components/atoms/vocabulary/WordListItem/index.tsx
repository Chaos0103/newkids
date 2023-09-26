import React from 'react';
import { WordListItemWrapper } from './style';
import { ReactComponent as Delete } from '../../../../assets/icons/delete.svg';

interface IWordListItemProps {
	text: string;
}

function WordListItem({ text }: IWordListItemProps) {
	const handleClick = () => {
		alert('삭제요');
	};
	return (
		<WordListItemWrapper>
			<div className="word-list-item">
				<p>{text}</p>
				<div className="check-box">
					<input type="checkbox" id="input" />
				</div>
				<Delete onClick={handleClick} />
			</div>
		</WordListItemWrapper>
	);
}

export default WordListItem;
