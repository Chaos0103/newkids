import React, { ReactNode } from 'react';
import { ContentLayout } from 'layouts/common/ContentLayout';
import { VocabularyLayoutContainer } from './style';

interface IVocabularyLayoutProps {
	VocabularyHeader: ReactNode;
	MyVocabulary: ReactNode;
}

function VocabularyLayout({ VocabularyHeader, MyVocabulary }: IVocabularyLayoutProps) {
	return (
		<VocabularyLayoutContainer>
			<div className="voca-header">
				<ContentLayout>{VocabularyHeader} </ContentLayout>
			</div>
			<div className="my-vocabulary">
				<ContentLayout>{MyVocabulary} </ContentLayout>
			</div>
		</VocabularyLayoutContainer>
	);
}

export default VocabularyLayout;
