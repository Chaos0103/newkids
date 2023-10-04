import React from 'react';
import { IMyKeyword } from 'types/keyword';
// import { DUMMY_MYKEYWORDS } from 'constants/dummyreadarticle';
import { MyActivityKeywordWrapper } from './style';

interface IMyActivityKeywordProps {
	myTopKeyword: IMyKeyword[];
}

function MyActivityKeyword(props: IMyActivityKeywordProps) {
	const { myTopKeyword } = props;
	// 더미테스트
	// const myKeyword = DUMMY_MYKEYWORDS;
	console.log(myTopKeyword);

	return (
		<MyActivityKeywordWrapper>
			<div className="keyword-rank-box">
				{myTopKeyword.map((keyword, index) => (
					<div className="keyword-rank-text" key={keyword.keywordId}>
						<p className="rank-number">{index + 1}</p>
						<p className="rank-title">{keyword.keyword}</p>
					</div>
				))}
			</div>
		</MyActivityKeywordWrapper>
	);
}

export default MyActivityKeyword;
