import React, { ReactNode } from 'react';
import { ModalComponentContainer } from './style';

interface IModalComponentProps {
	children: ReactNode;
	isOpen: boolean;
	onClose: () => void;
}

function ModalComponent(props: IModalComponentProps) {
	const { children, isOpen, onClose } = props;

	return (
		<ModalComponentContainer onClick={onClose} isOpen={isOpen}>
			{children}
		</ModalComponentContainer>
	);
}

export default ModalComponent;
