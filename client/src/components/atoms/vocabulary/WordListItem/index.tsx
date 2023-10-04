import React, { useState } from 'react';
import { IGetallVocaBody } from 'types/vocabulary';
import { checkVocabularyApi, deleteVocabularyApi } from 'utils/apis/vocabulary';
import Button from 'components/atoms/common/Button';
import { WordListItemWrapper } from './style';
import { ReactComponent as Delete } from '../../../../assets/icons/delete.svg';

interface WordListItemProps {
	items: IGetallVocaBody[]; // items 속성의 타입을 정의합니다.
}

function WordListItem({ items }: WordListItemProps) {
	const [selectedItem, setSelectedItem] = useState<IGetallVocaBody | undefined>(undefined);
	const [isOverlayOpen, setIsOverlayOpen] = useState(false);

	const handleItemClick = (item: IGetallVocaBody) => {
		setSelectedItem(item);
		setIsOverlayOpen(true);
	};

	const handleOverlayClose = () => {
		setIsOverlayOpen(false); // 오버레이창을 닫는 함수
	};

	const handleDelete = async (vocabularyId: string) => {
		try {
			const response = await deleteVocabularyApi(vocabularyId);
			console.log('delete클릭', response);
			if (response.status === 200) {
				alert('삭제되었습니다.');
				const reSearchPageEvent = new Event('reSearchPage');
				window.dispatchEvent(reSearchPageEvent);
			}
		} catch (error) {
			console.error('삭제 오류발생');
		}
	};

	const handleClick = async (vocabularyId: string, checked: boolean) => {
		if (!checked) {
			try {
				const response = await checkVocabularyApi(vocabularyId);
				console.log('알아요 체크', response);
				if (response.status === 200) {
					alert('체크되었습니다.');
					const checkVocabularyEvent = new Event('checkVocabulary');
					window.dispatchEvent(checkVocabularyEvent);
				}
			} catch (error) {
				console.error('알아요 체크 오류');
			}
		} else if (checked) {
			try {
				const response = await checkVocabularyApi(vocabularyId);
				console.log('알아요 체크', response);
				if (response.status === 200) {
					alert('체크해제되었습니다.');
					const checkVocabularyEvent = new Event('checkVocabulary');
					window.dispatchEvent(checkVocabularyEvent);
				}
			} catch (error) {
				console.error('알아요 체크 오류');
			}
		}
	};

	return (
		<WordListItemWrapper>
			{items.map((item) => (
				<div className="word-list-item" key={item.vocabularyId}>
					<p className="item-vocabulary-content" onClick={() => handleItemClick(item)} role="presentation">
						{item.content}
					</p>
					{isOverlayOpen && selectedItem !== undefined && (
						<div className="overlay">
							<div className="overlay-content">
								<p className="selected-item-content">{selectedItem.content}</p>
								<p className="selected-item-description">(뜻) {selectedItem.description}</p>
								<Button color="Primary" size="s" text="닫기" radius="m" handleClick={handleOverlayClose} />
							</div>
						</div>
					)}
					<div className="check-box">
						<input
							type="checkbox"
							id="input"
							onClick={async () => handleClick(item.vocabularyId.toString(), item.checked)}
							defaultChecked={item.checked}
						/>
					</div>
					<Delete onClick={async () => handleDelete(item.vocabularyId.toString())} />
				</div>
			))}
		</WordListItemWrapper>
	);
}

export default WordListItem;
