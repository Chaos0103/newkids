import React, { ReactNode } from 'react';
import { ContentLayoutContainer, FullContentLayoutContainer, LarrowContentLayoutContainer } from './style';

interface IContentLayoutProps {
	children: ReactNode;
}

export function LarrowContentLayout({ children }: IContentLayoutProps) {
	return <LarrowContentLayoutContainer>{children}</LarrowContentLayoutContainer>;
}

export function ContentLayout({ children }: IContentLayoutProps) {
	return <ContentLayoutContainer>{children}</ContentLayoutContainer>;
}

export function FullContentLayout({ children }: IContentLayoutProps) {
	return <FullContentLayoutContainer>{children}</FullContentLayoutContainer>;
}
