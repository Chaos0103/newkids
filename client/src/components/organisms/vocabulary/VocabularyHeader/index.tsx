import React from 'react';
import SearchBar from 'components/atoms/common/SearchBar';
import VocabularyButton from 'components/atoms/vacabulary/VocabularyButton';
import { VocabularyHeaderContainer } from './style';

function VocabularyHeader() {
	return (
		<VocabularyHeaderContainer>
			<div className="vocabulary-header">
				<VocabularyButton />
				<SearchBar size="s" confirmSearch={() => {}} />
			</div>
		</VocabularyHeaderContainer>
	);
}

export default VocabularyHeader;
