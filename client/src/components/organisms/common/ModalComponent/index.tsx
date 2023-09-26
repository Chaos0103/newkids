import React, { ReactNode } from 'react';
import { ModalComponentContainer } from './style';

interface IModalComponentProps {
	children: ReactNode;
	// isOpen: boolean;
	onClose: () => void;
}

function ModalComponent(props: IModalComponentProps) {
	const { children, onClose } = props;
	const closeModal = () => {
		onClose();
	};

	return (
		<ModalComponentContainer onClick={closeModal}>
			<div className="modal-body" onClick={(e) => e.stopPropagation()} role="presentation">
				{children}
			</div>
		</ModalComponentContainer>
	);
}

export default ModalComponent;
