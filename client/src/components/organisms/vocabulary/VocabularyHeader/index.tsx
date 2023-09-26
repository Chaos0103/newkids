import React, { useState } from 'react';
import SearchBar from 'components/atoms/common/SearchBar';
import VocabularyButton from 'components/atoms/vocabulary/VocabularyButton';
import { VocabularyHeaderContainer } from './style';

function VocabularyHeader() {
	const [value, setValue] = useState('');
	return (
		<VocabularyHeaderContainer>
			<div className="vocabulary-header">
				<VocabularyButton />
				<SearchBar
					size="s"
					placeholder="검색어를 입력해주세요"
					color="SubSecond"
					value={value}
					setValue={setValue}
					confirmSearch={() => {}}
				/>
			</div>
		</VocabularyHeaderContainer>
	);
}

export default VocabularyHeader;
