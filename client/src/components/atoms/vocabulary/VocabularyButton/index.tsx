import React from 'react';
import { VocabularyButtonWrapper } from './style';

function VocabularyButton() {
	const handleClick = () => {};
	return (
		<VocabularyButtonWrapper>
			<div className="voca-menu">
				<button type="button" className="voca-total-button" onClick={handleClick}>
					<p className="total-button-title">전체</p>
					<p className="total-count">20</p>
				</button>
				<button type="button" className="voca-know-button" onClick={handleClick}>
					<p className="know-button-title">알아요</p>
					<p className="know-count">20</p>
				</button>
			</div>
		</VocabularyButtonWrapper>
	);
}

export default VocabularyButton;
