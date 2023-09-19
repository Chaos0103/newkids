import React, { ReactNode } from 'react';
import { LarrowContentLayout } from 'layouts/common/ContentLayout';
import { JoinPageLayoutContainer } from './style';

interface IJoinPageLayoutProps {
	StepView: ReactNode;
}
function JoinPageLayout({ StepView }: IJoinPageLayoutProps) {
	return (
		<JoinPageLayoutContainer>
			<LarrowContentLayout>
				<div className="step-view">{StepView}</div>
			</LarrowContentLayout>
		</JoinPageLayoutContainer>
	);
}

export default JoinPageLayout;
