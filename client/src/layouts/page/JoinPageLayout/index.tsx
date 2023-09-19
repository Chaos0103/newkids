import React, { ReactNode } from 'react';
import { LarrowContentLayout } from 'layouts/common/ContentLayout';
import { JoinPageLayoutContainer } from './style';

interface IJoinPageLayoutProps {
	StepView: ReactNode;
}
function JoinPageLayout({ StepView }: IJoinPageLayoutProps) {
	return (
		<JoinPageLayoutContainer>
			<div className="terms">
				<LarrowContentLayout>{StepView}</LarrowContentLayout>
			</div>
		</JoinPageLayoutContainer>
	);
}

export default JoinPageLayout;
