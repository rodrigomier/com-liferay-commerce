/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.commerce.bom.rest.internal.dto.v1_0.converter;

import com.liferay.commerce.bom.model.CommerceBOMEntry;
import com.liferay.commerce.bom.rest.dto.v1_0.Position;
import com.liferay.commerce.bom.service.CommerceBOMEntryService;
import com.liferay.headless.commerce.core.dto.v1_0.converter.DTOConverter;
import com.liferay.headless.commerce.core.dto.v1_0.converter.DTOConverterContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Alessio Antonio Rendina
 */
@Component(
	property = "model.class.name=commerceBOMEntryPosition",
	service = {DTOConverter.class, PositionDTOConverter.class}
)
public class PositionDTOConverter implements DTOConverter {

	@Override
	public String getContentType() {
		return Position.class.getSimpleName();
	}

	public Position toDTO(DTOConverterContext dtoConverterContext)
		throws Exception {

		CommerceBOMEntry commerceBOMEntry =
			_commerceBOMEntryService.getCommerceBOMEntry(
				dtoConverterContext.getResourcePrimKey());

		return new Position() {
			{
				x = commerceBOMEntry.getPositionX();
				y = commerceBOMEntry.getPositionY();
			}
		};
	}

	@Reference
	private CommerceBOMEntryService _commerceBOMEntryService;

}