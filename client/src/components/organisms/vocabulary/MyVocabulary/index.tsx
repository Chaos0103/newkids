import React from 'react';
import WordListItem from 'components/atoms/vocabulary/WordListItem';
import { MyVocabularyContainer } from './style';

function createRingElements(numberOfRings: number, gapPercentage: number) {
	const ringElements = [];

	for (let i = 1; i < numberOfRings; i += 1) {
		const leftPosition = `${i * gapPercentage}%`;
		const ring = (
			<div>
				<div className="ring-border" key={i} style={{ left: leftPosition }} />
				<div className="ring-border-1" key={i} style={{ left: leftPosition }} />
				<div className="ring" key={i} style={{ left: leftPosition }}>
					<div className="small-ring" />
				</div>
			</div>
		);
		ringElements.push(ring);
	}

	return ringElements;
}

function MyVocabulary() {
	const numberOfRings = 10; // 원하는 고리의 수
	const ringElements = [];

	for (let i = 1; i < numberOfRings; i += 1) {
		const leftPosition = `${i * 10}%`; // 원하는 간격을 백분율로 설정

		ringElements.push(<div className="ring" key={i} style={{ left: leftPosition }} />);
	}
	return (
		<MyVocabularyContainer>
			<div className="notebook-size">
				<div className="sort-button">
					<div className="sort-button-text" onClick={() => {}} role="presentation">
						최신 순 |
					</div>
				</div>
				<hr className="vertical-line" />
				{createRingElements(10, 10)}
				<div className="voca-book">
					<div className="left-page">
						<div className="left-title">
							<p>단어</p>
							<p>알아요</p>
							<p>삭제</p>
						</div>
						<hr />
						<div className="word-list">
							<WordListItem text="물티슈" />
							<WordListItem text="물티슈" />
							<WordListItem text="물티슈" />
							<WordListItem text="물티슈" />
							<WordListItem text="물티슈" />
						</div>
					</div>
					<div className="right-page">
						<div className="right-title">
							<p>단어</p>
							<p>알아요</p>
							<p>삭제</p>
						</div>
						<hr />
						<div className="word-list">
							<WordListItem text="물티슈" />
							<WordListItem text="물티슈" />
							<WordListItem text="물티슈" />
							<WordListItem text="물티슈" />
							<WordListItem text="물티슈" />
						</div>
					</div>
				</div>
			</div>
		</MyVocabularyContainer>
	);
}

export default MyVocabulary;
