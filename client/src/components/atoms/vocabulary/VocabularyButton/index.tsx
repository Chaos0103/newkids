import React, { useEffect, useState } from 'react';
import { getCheckVocabularyApi } from 'utils/apis/vocabulary';
import { VocabularyButtonWrapper } from './style';

interface IVocabularyButton {
	totalElements: number;
}

function VocabularyButton(props: IVocabularyButton) {
	const { totalElements } = props;
	const [vocaCheckCnt, setVocaCheckCnt] = useState(0);
	const memberkey = localStorage.getItem('memberkey');

	const handleClick = () => {};

	const getCheckVocabulary = async () => {
		try {
			if (memberkey) {
				const response = await getCheckVocabularyApi(memberkey);
				if (response.status === 200) {
					console.log(memberkey);
					setVocaCheckCnt(response.data.data.checkedCount);
					console.log('체크 단어 갯수', response);
				}
			}
		} catch (e) {
			console.log(e);
		}
	};

	useEffect(() => {
		getCheckVocabulary();
		window.addEventListener('checkVocabulary', getCheckVocabulary);
		return () => {
			window.removeEventListener('checkVocabulary', getCheckVocabulary);
		};
	}, []);

	return (
		<VocabularyButtonWrapper>
			<div className="voca-menu">
				<button type="button" className="voca-total-button" onClick={handleClick}>
					<p className="total-button-title">전체</p>
					<p className="total-count">{totalElements}</p>
				</button>
				<button type="button" className="voca-know-button" onClick={handleClick}>
					<p className="know-button-title">알아요</p>
					<p className="know-count">{vocaCheckCnt}</p>
				</button>
			</div>
		</VocabularyButtonWrapper>
	);
}

export default VocabularyButton;
