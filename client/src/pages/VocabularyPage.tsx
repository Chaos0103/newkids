import MyVocabulary from 'components/organisms/vocabulary/MyVocabulary';
import VocabularyHeader from 'components/organisms/vocabulary/VocabularyHeader';
import PageLayout from 'layouts/common/PageLayout';
import VocabularyLayout from 'layouts/page/VocabularyLayout';
import React from 'react';

function VocabularyPage() {
	return (
		<PageLayout>
			<VocabularyLayout VocabularyHeader={<VocabularyHeader />} MyVocabulary={<MyVocabulary />} />
		</PageLayout>
	);
}

export default VocabularyPage;
